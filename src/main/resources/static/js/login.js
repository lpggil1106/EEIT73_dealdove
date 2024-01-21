import {auth, provider, signInWithPopup, onAuthStateChanged, signInWithEmailAndPassword} from "./firebase.js";
import "https://code.jquery.com/jquery-3.6.0.min.js";


function  reflash(){

}
$(document).ready(() => {
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
        onAuthStateChanged(auth,(user=>{
            if(user){
                const user = auth.currentUser;
                const isEmailVerified = user.emailVerified;
                const email = $('#email').val();
                const password = $('#password').val();

                if(isEmailVerified){
                  signInWithEmailAndPassword(auth,email,password)
                      .then(()=>{console.log('123');
                      window.location.href='/Dealdove'})
                }else{
                    window.alert('尚未認證')
                }
            }else{
                // const isEmailVerified = user.emailVerified;
                const email = $('#email').val();
                const password = $('#password').val();

                signInWithEmailAndPassword(auth, email, password)
                    .then(()=> {
                        const user = auth.currentUser;
                        const isEmailVerified = user.emailVerified;

                        if(isEmailVerified){
                            console.log('success');
                        }else{
                            console.log('no');
                        }
                    })
                    .catch(error=>{console.log(error);
                    window.alert('尚未註冊')})
            }
        }))








    //     const user = auth.currentUser;
    //     if (user!=null){
    //     console.log(user);
    //         const isEmailVerified = user.emailVerified;
    //
    //         if(isEmailVerified){
    //             const email = $('#email').val();
    //             const password = $('#password').val();
    //
    //             signInWithEmailAndPassword(auth, email, password)
    //                 .then(() => {
    //                     window.location.href='/Dealdove'
    //                 })
    //                 .catch(error => {
    //                     console.log(error);
    //                 })
    //         }else{
    //             window.alert('尚未驗證電子信箱');
    //         }
    //     }else{
    //         window.alert('尚未註冊帳號');
    //         window.location.href='/Register';
    //     }
    //
    });
})


// 送 ID Token 回後端的函數
function sendTokenToBackend(idToken) {
    const apiUrl = '/login3';
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

