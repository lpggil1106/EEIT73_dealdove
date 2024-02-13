import {auth, createUserWithEmailAndPassword, sendEmailVerification} from "./firebase.js"
import "https://code.jquery.com/jquery-3.6.0.min.js";
import {showToast} from "./jquery.toast.js";

$(document).ready(() => {


    $('#register-button').on('click', () => {
        event.preventDefault();
        const EmailAndPasssword = {
            email: $('#email').val(),
            password: $('#password').val()
        };

        fetch('/verify', {
                method: 'POST',
                body: JSON.stringify(EmailAndPasssword),
                headers: {'Content-Type': 'application/json;charset=utf-8'}
            }
        ).then(res =>
            res.json()
        ).then(res => {
            if (res === 10) {
                showToast('註冊失敗',"請輸入正確的電子信箱");
            } else if (res === 20) {
                showToast('註冊失敗',"輸入的密碼要是8~16碼的英數字");
            }else if(res===30){
              showToast('註冊失敗',"已註冊過帳號");
              window.location.href="/Login";
            } else if (res === 1) {
                if ($('#privacy-checkbox').prop('checked')) {
                    const email = $('#email').val();
                    const password = $('#password').val();

                    createUserWithEmailAndPassword(auth, email, password)
                        .then(userCredential => {
                            sendEmailVerification(userCredential.user)
                                .then(() => {
                                    showToast('註冊失敗','驗證信已送出')
                                    window.location.href = '/Login'
                                })
                                .catch(error => console.log(error))
                            const user = userCredential.user;
                            return user.getIdToken();
                        })
                        .then(idToken => {
                            console.log('IdToken:', idToken);
                            sendTokenToBackend(idToken);
                        })
                        .catch(error => console.log(error))
                } else {
                    showToast('註冊失敗','尚未確認隱私條款');
                }
            }
        }).catch(error => console.log(error))
    });
})


// 送 ID Token 回後端的函數
function sendTokenToBackend(idToken) {
    const apiUrl = '/Users';
    const requestOptions = {
        method: 'POST',
        body: JSON.stringify({
            idToken: idToken
        }),
        headers: {'Content-Type': 'application/json;charset=utf-8'}
    };

    fetch(apiUrl, requestOptions)
        .then(response => response.json())
        .then(data => {
            // 在這裡處理後端的回應
            console.log('後端回應:', data);
        })
        .catch(error => {
            console.error('錯誤:', error);
        });
}
