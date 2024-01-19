import {auth, onAuthStateChanged, signOut} from "./firebase.js";
import "https://code.jquery.com/jquery-3.6.0.min.js";

$(document).ready(() => {
    onAuthStateChanged(auth, (user) => {
        if (user) {
            $('#login').html("<a href='' id='login'>登出</a>").addClass('login');
        }
    });

    let isLogin;
    $('#login').on('click', () => {
        if ($('#login').hasClass('login')) {
            isLogin = confirm('確定要登出嗎');
            if (isLogin) {
                signOut(auth)
                    .then(()=>
                        {window.alert('已登出')})
                    .catch(error=>{
                        console.log(error)
                    })
                window.location.href='/Login';
                $('#login').toggleClass('login');
            }
        }
    })
})
