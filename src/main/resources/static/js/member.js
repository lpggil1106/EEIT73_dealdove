import {auth, onAuthStateChanged} from './firebase.js';
import "https://code.jquery.com/jquery-3.6.0.min.js";


$(document).ready(() => {
    onAuthStateChanged(auth, (user => {
            if (user) {
                const idToken = user.getIdToken()
                    .then(idToken => {
                        console.log(idToken);
                        sendTokenToBackend(idToken);
                    })
                    .then(email => {
                        console.log(email)
                    })
            }
        })
    );
    $('#update').on('click', function () {
        // 取得選中的單選按鈕的值
        var selectedGender = $('input[name="gender"]:checked').val();
        console.log("選中的性別是：" + selectedGender);

        fetch('/gender',{
            method:'POST',
            headers:{'Content-Type': 'application/json;charset=utf-8'},
            body:JSON.stringify({"gender":selectedGender})
        }).then(res=> res.json())
            .then(res=>console.log(res))

    });
})

function sendTokenToBackend(idToken) {
    const apiUrl = '/memberEmail';
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
            $('#email').prop('value', data.email);
        })
        .catch(error => {
            console.error('錯誤:', error);
        });
}





