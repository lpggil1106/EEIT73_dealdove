import {auth, onAuthStateChanged, signOut} from "./firebase.js";
import "https://code.jquery.com/jquery-3.6.0.min.js";

$(document).ready(() => {
    let canLogin = true;
        onAuthStateChanged(auth, (user) => {
            if (user) {
                $('#login').html("<a href='' id='login'>登出</a>").addClass('login');
            }else{
                $('#member').html("<a id='member' href='/Login' class=' link-underline link-underline-opacity-0 text-secondary'> 會員中心</a>")
                $('#seller-home').html("<a id='seller-home' href='./Login' class=' link-underline link-underline-opacity-0 text-secondary'> 賣場管理</a>")
            }
        });


    let isLogout;

    $('#login').on('click', () => {
        if ($('#login').hasClass('login')) {
            isLogout = confirm('確定要登出嗎');
            if (isLogout) {
                signOut(auth)
                    .then(()=>
                        {window.alert('已登出');
                        canLogin=true;
                        window.location.href='/Dealdove'
                        })
                    .catch(error=>{
                        console.log(error)
                    })
                // window.location.href='/Login';
                $('#login').toggleClass('login');
            }
        }
    })
})
