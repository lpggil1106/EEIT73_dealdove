import {auth, createUserWithEmailAndPassword, sendEmailVerification} from "./firebase.js"
import "https://code.jquery.com/jquery-3.6.0.min.js";

$(document).ready(() => {
    $('#register-button').on('click', () => {
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
                window.alert("請輸入正確的電子信箱");
            } else if (res === 20) {
                window.alert("輸入的密碼要是8~16碼的英數字");
            } else if (res === 1) {
                if ($('#privacy-checkbox').prop('checked')) {
                    const email = $('#email').val();
                    const password = $('#password').val();

                    createUserWithEmailAndPassword(auth, email, password)
                        .then(userCredential => {
                            sendEmailVerification(userCredential.user)
                                .then(()=>{
                                    window.alert('驗證信已送出')
                                    window.location.href='/Login'
                                })
                                .catch(error=>console.log(error))
                        })
                        .catch(error=>console.log(error))
                }else{
                    window.alert('尚未確認隱私條款');
                }
            }
        }).catch(error => console.log(error))
    });
})