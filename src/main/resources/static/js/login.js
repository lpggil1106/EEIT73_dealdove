import {auth, provider, signInWithPopup, onAuthStateChanged, signInWithEmailAndPassword} from "./firebase.js";
import "https://code.jquery.com/jquery-3.6.0.min.js";
import{showToast} from "./jquery.toast.js";

function reflash() {

}

$(document).ready(() => {
    changeCaptcha();
    //Google登入
    $('#google-signIn').on('click', () => {
        onAuthStateChanged(auth, (user) => {
            //已登入
            if (user) {
                const uid = user.uid;
                window.location.href = "/Dealdove";
                console.log('login!')
            } else {
                // 設定帳號選擇
                provider.setCustomParameters({prompt: 'select_account'})
                signInWithPopup(auth, provider)
                    .then(result => {
                        const user = result.user;
                        return user.getIdToken();
                    })
                    .then(idToken => {
                        console.log('IdToken:', idToken);
                        sendTokenToBackend(idToken);
                    })
                    .catch(error => {
                        console.log(error);
                    })
            }
        })
    });

    // Email信箱登入
    $('#login-button').on('click', () => {
        onAuthStateChanged(auth, (user => {
            const userCaptcha = $('#captcha').val();
            if (user) {
                if (userCaptcha===(captcha)) {
                    const user = auth.currentUser;
                    const isEmailVerified = user.emailVerified;
                    const email = $('#email').val();
                    const password = $('#password').val();

                    // if (isEmailVerified) {
                        signInWithEmailAndPassword(auth, email, password)
                            .then(result => {
                                const user = result.user;
                                return user.getIdToken();
                            })
                            .then(IdToken => {
                                sendTokenToBackend(IdToken);
                                window.location.href = '/Dealdove';
                            })
                    // } else {
                    //     window.alert('尚未認證')
                    //     window.location.reload();
                    // }
                } else {
                    console.log('error')
                }
            } else {
                if (userCaptcha === captcha) {
                    const email = $('#email').val();
                    const password = $('#password').val();

                    signInWithEmailAndPassword(auth, email, password)
                        .then(() => {
                            const user = auth.currentUser;
                            const isEmailVerified = user.emailVerified;

                            if (isEmailVerified) {
                                console.log('success');
                            } else {
                                console.log('no');
                            }
                        })
                        .catch(error => {
                            const errorCode = error.code;
                            const errorMessage = error.message;
                            console.log(errorCode);
                           if(errorCode==='auth/too-many-requests'){
                               showToast('登入失敗','登入失敗太多次請更改密碼或稍後重新登入');
                           }else if(errorCode==='auth/invalid-credential'){
                               showToast('登入失敗','尚未註冊或是密碼錯誤')
                           }
                        })
                } else {
                    console.log('error')
                    showToast('Error','驗證碼輸入錯誤')
                }
            }
        }))

    });
    $('.captchaimg').on('click', () => {
        changeCaptcha();
    });
})

let captcha;

function changeCaptcha() {
    fetch('captcha')
        .then(res => res.json())
        .then(res => {
                $('#captchaimg').prop('src', "data:image/png;base64," + res.base64String);
                captcha = res.captchCode;
            }
        )
        .catch(error => console.log(error))
}

// 送 ID Token 回後端的函數
function sendTokenToBackend(idToken) {
    const apiUrl = '/Users';
    const requestOptions = {
        method: 'POST',
        body: JSON.stringify({
            "idToken": idToken
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

// 送 ID Token 回後端的函數


