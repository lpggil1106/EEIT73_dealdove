'use strict';

const usernamePage = document.querySelector('#username-page');
const chatPage = document.querySelector('#chat-page');
const usernameForm = document.querySelector('#usernameForm');
const messageForm = document.querySelector('#messageForm');
const messageInput = document.querySelector('#message');
const connectingElement = document.querySelector('.connecting');
const chatArea = document.querySelector('#chat-messages');
const logout = document.querySelector('#logout');

let stompClient = null;
let nickname = null;
let fullname = null;
let selectedUserId = null;

function connect(event) {
    nickname = document.querySelector('#nickname').value.trim();
    fullname = document.querySelector('#fullname').value.trim();

    if (nickname && fullname) {
        usernamePage.classList.add('hidden');
        chatPage.classList.remove('hidden');

        const socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, onConnected, onError);
    }
    event.preventDefault();
}


function onConnected() {
    stompClient.subscribe(`/user/${nickname}/queue/messages`, onMessageReceived);
    stompClient.subscribe(`/user/public`, onMessageReceived);

    // register the connected user
    stompClient.send("/app/user.addUser",
        {},
        JSON.stringify({nickName: nickname, fullName: fullname, status: 'ONLINE'})
    );
    document.querySelector('#connected-user-fullname').textContent = fullname;
    findAndDisplayConnectedUsers().then();
}

async function findAndDisplayConnectedUsers() {
    const connectedUsersResponse = await fetch('/users');
    let connectedUsers = await connectedUsersResponse.json();
    connectedUsers = connectedUsers.filter(user => user.nickName !== nickname);
    const connectedUsersList = document.getElementById('connectedUsers');
    connectedUsersList.innerHTML = '';

    connectedUsers.forEach(user => {
        appendUserElement(user, connectedUsersList);
        if (connectedUsers.indexOf(user) < connectedUsers.length - 1) {
            const separator = document.createElement('li');
            separator.classList.add('separator');
            connectedUsersList.appendChild(separator);
        }
    });
}

function appendUserElement(user, connectedUsersList) {
    const listItem = document.createElement('li');
    listItem.classList.add('user-item');
    listItem.id = user.nickName;

    const userImage = document.createElement('img');
    userImage.src = '../img/user_icon.png';
    userImage.alt = user.fullName;

    const usernameSpan = document.createElement('span');
    usernameSpan.textContent = user.fullName;

    const receivedMsgs = document.createElement('span');
    receivedMsgs.textContent = '0';
    receivedMsgs.classList.add('nbr-msg', 'hidden');

    listItem.appendChild(userImage);
    listItem.appendChild(usernameSpan);
    listItem.appendChild(receivedMsgs);

    listItem.addEventListener('click', userItemClick);

    connectedUsersList.appendChild(listItem);
}

function userItemClick(event) {
    document.querySelectorAll('.user-item').forEach(item => {
        item.classList.remove('active');
    });
    messageForm.classList.remove('hidden');

    const clickedUser = event.currentTarget;
    clickedUser.classList.add('active');

    selectedUserId = clickedUser.getAttribute('id');
    fetchAndDisplayUserChat().then();

    const nbrMsg = clickedUser.querySelector('.nbr-msg');
    nbrMsg.classList.add('hidden');
    nbrMsg.textContent = '0';

}

function displayMessage(senderId, content) {
    const messageContainer = document.createElement('div');
    messageContainer.classList.add('message');
    if (senderId === nickname) {
        messageContainer.classList.add('sender');
    } else {
        messageContainer.classList.add('receiver');
    }
    const message = document.createElement('p');
    message.textContent = content;
    messageContainer.appendChild(message);
    chatArea.appendChild(messageContainer);
}

async function fetchAndDisplayUserChat() {
    const userChatResponse = await fetch(`/messages/${nickname}/${selectedUserId}`);
    const userChat = await userChatResponse.json();
    chatArea.innerHTML = '';
    userChat.forEach(chat => {
        displayMessage(chat.senderId, chat.content);
    });
    chatArea.scrollTop = chatArea.scrollHeight;
}


function onError() {
    connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
    connectingElement.style.color = 'red';
}


function sendMessage(event) {
    const messageContent = messageInput.value.trim();
    if (messageContent && stompClient) {
        const chatMessage = {
            senderId: nickname,
            recipientId: selectedUserId,
            content: messageInput.value.trim(),
            timestamp: new Date()
        };
        stompClient.send("/app/chat", {}, JSON.stringify(chatMessage));
        displayMessage(nickname, messageInput.value.trim());
        messageInput.value = '';
    }
    chatArea.scrollTop = chatArea.scrollHeight;
    event.preventDefault();
}


async function onMessageReceived(payload) {
    await findAndDisplayConnectedUsers();
    console.log('Message received', payload);
    const message = JSON.parse(payload.body);
    if (selectedUserId && selectedUserId === message.senderId) {
        displayMessage(message.senderId, message.content);
        chatArea.scrollTop = chatArea.scrollHeight;
    }

    if (selectedUserId) {
        document.querySelector(`#${selectedUserId}`).classList.add('active');
    } else {
        messageForm.classList.add('hidden');
    }

    const notifiedUser = document.querySelector(`#${message.senderId}`);
    if (notifiedUser && !notifiedUser.classList.contains('active')) {
        const nbrMsg = notifiedUser.querySelector('.nbr-msg');
        nbrMsg.classList.remove('hidden');
        nbrMsg.textContent = '';
    }
}

function onLogout() {
    stompClient.send("/app/user.disconnectUser",
        {},
        JSON.stringify({nickName: nickname, fullName: fullname, status: 'OFFLINE'})
    );
    window.location.reload();
}

usernameForm.addEventListener('submit', connect, true); // step 1
messageForm.addEventListener('submit', sendMessage, true);
logout.addEventListener('click', onLogout, true);
window.onbeforeunload = () => onLogout();

//////////////////////////////////////////////////////////////////////////////////////////
document.addEventListener('DOMContentLoaded', (event) => {
    // 您的程式碼...

// 建立WebSocket连接
    let url = 'ws://localhost:8080/chat'; // 根据您的后端WebSocket服务器地址修改
    var ws = new WebSocket(url);

    // 监听连接打开事件
    ws.onopen = () => {
        console.log('WebSocket connection opened.');
    };

    // 监听连接关闭事件
    ws.onclose = () => {
        console.log('WebSocket connection closed.');
    };

    // 监听接收到的消息
    ws.onmessage = event => {
        let receivedMessage = event.data;
        console.log("Received message: " + receivedMessage);
        // 在这里可以添加将消息显示在聊天框中的逻辑
    };

    // 发送消息的函数
    function sendMessage() {
        var messageInput = document.getElementById('message-input');
        var messageText = messageInput.value.trim();

        if (messageText && ws.readyState === WebSocket.OPEN) {
            ws.send(messageText);  // 发送消息到WebSocket服务器
            console.log("Sent message: " + messageText);

            // 清空输入框
            messageInput.value = '';
        }
    }

    ws.onmessage = event => {
        let receivedMessage = event.data;
        console.log("Received message: " + receivedMessage);

        // 将消息添加到聊天历史中
        var chatHistory = document.getElementById('chat-history');
        var messageDiv = document.createElement('div');
        messageDiv.classList.add('message', 'other'); // 'other' 表示接收到的消息

        var contentSpan = document.createElement('span');
        contentSpan.classList.add('message-content');
        contentSpan.textContent = receivedMessage;

        var timestampSpan = document.createElement('span');
        timestampSpan.classList.add('timestamp');
        timestampSpan.textContent = getCurrentTime();

        messageDiv.appendChild(contentSpan);
        messageDiv.appendChild(timestampSpan);
        chatHistory.appendChild(messageDiv);
        chatHistory.scrollTop = chatHistory.scrollHeight;
    }


    // 聯絡人切換
    function toggleChat() {
        var chatContainer = document.getElementById("chat-container");
        var chatIcon = document.getElementById("chat-icon");

        if (chatContainer.style.display === "flex") {
            chatContainer.style.display = "none";
            chatIcon.style.display = "block";
        } else {
            chatContainer.style.display = "flex";
            chatIcon.style.display = "none";
        }
    }

    document.querySelectorAll('.contact-item').forEach(item => {
        item.addEventListener('click', function () {
            // 更新聊天框內容，這裡需要根據您的實際情況進行調整
            document.getElementById('username').textContent = this.querySelector('.contact-name').textContent;
            // 清空當前聊天歷史
            document.getElementById('chat-history').innerHTML = '';
            // 可以添加更多的功能，例如加載該聯絡人的聊天歷史
        });
    });


    window.onload = function () {
        var chatContainer = document.getElementById("chat-container");
        var chatIcon = document.getElementById("chat-icon");
        chatContainer.style.display = "none";
        chatIcon.style.display = "block";
    };
    document.addEventListener("DOMContentLoaded", () => {
        // 預設的聯絡人名稱
        updateUsername('聯絡人1');

        // 監聽所有聯絡人項目的點擊事件
        document.querySelectorAll('.contact-item').forEach(item => {
            item.addEventListener('click', function () {
                let contactName = this.querySelector('.contact-name').textContent;
                updateUsername(contactName);

                // 這裡可以添加更多功能，例如加載該聯絡人的聊天歷史等
            });
        });
    });


    // 更新聊天頭部的使用者名稱
    function updateUsername(name) {
        document.getElementById('username').textContent = name;
    }

    // 如果需要根據最後對話時間進行排序，則需要從後端獲取數據並在這裡實現排序邏輯
    // ...
    function loadChat(contactName) {
        // 更新聊天標題
        document.getElementById('username').textContent = contactName;

        // 假設這裡是聯絡人1的對話
        if (contactName === '聯絡人1') {
            document.getElementById('chat-history').innerHTML = `
            <!-- 聯絡人1的對話內容 -->
            <!-- 對話內容... -->
        `;
        }
        // 其他聯絡人的對話加載邏輯...
    }

    function toggleStickerPanel() {
        var panel = document.getElementById("sticker-panel");
        panel.style.display = panel.style.display === "none" ? "block" : "none";
    }

    function selectSticker(stickerPath) {
        // 處理選擇的貼圖
        console.log("選擇的貼圖: " + stickerPath);
        // 您可以在這裡添加將貼圖插入聊天框的邏輯
    }

    function selectSticker(sticker) {
        var messageInput = document.getElementById('message-input');
        var stickerPanel = document.getElementById('sticker-panel');

        // 將表情符號添加到輸入框的現有內容中
        messageInput.value += sticker;

        // 將焦點設定回輸入框
        messageInput.focus();

        // 隱藏表情選擇視窗
        stickerPanel.style.display = 'none';
    }


    // 選擇圖片後立即處理上傳
    function prepareImageUpload() {
        var fileInput = document.getElementById('image-input');

        if (fileInput.files && fileInput.files[0]) {
            uploadImageToChat(); // 直接調用上傳圖片函數
        }
    }

    // 上傳圖片到聊天歷史
    function uploadImageToChat() {
        var fileInput = document.getElementById('image-input');
        var chatHistory = document.getElementById('chat-history');

        if (fileInput.files && fileInput.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                var imgDiv = document.createElement('div');
                imgDiv.classList.add('message', 'self');

                var img = document.createElement('img');
                img.src = e.target.result;
                img.alt = 'Uploaded Image';

                imgDiv.appendChild(img);
                chatHistory.appendChild(imgDiv);
                chatHistory.scrollTop = chatHistory.scrollHeight;
            };

            reader.readAsDataURL(fileInput.files[0]);
        }
    }

    // 獲取當前時間的函數
    function getCurrentTime() {
        var now = new Date();
        return now.getHours().toString().padStart(2, '0') + ':' + now.getMinutes().toString().padStart(2, '0');
    }


    // 以下是處理發送訊息的 JavaScript 函數
    function sendMessage() {
        var messageInput = document.getElementById('message-input');
        var chatHistory = document.getElementById('chat-history');
        var messageText = messageInput.value.trim();

        if (messageText) {
            var messageDiv = document.createElement('div');
            messageDiv.classList.add('message', 'self');

            var contentSpan = document.createElement('span');
            contentSpan.classList.add('message-content');
            contentSpan.textContent = messageText;

            var timestampSpan = document.createElement('span');
            timestampSpan.classList.add('timestamp');
            timestampSpan.textContent = getCurrentTime();

            messageDiv.appendChild(contentSpan);
            messageDiv.appendChild(timestampSpan);

            chatHistory.appendChild(messageDiv);
            chatHistory.scrollTop = chatHistory.scrollHeight;

            messageInput.value = '';
        }
    }

    function getCurrentTime() {
        var now = new Date();
        return now.getHours().toString().padStart(2, '0') + ':' + now.getMinutes().toString().padStart(2, '0');
    }

    document.getElementById('message-input').addEventListener('keydown', function (event) {
        if (event.key === 'Enter' && !event.shiftKey) {
            event.preventDefault(); // 防止預設的換行行為
            sendMessage();
        }
    });


});
