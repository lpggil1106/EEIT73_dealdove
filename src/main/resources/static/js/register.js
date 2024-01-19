import {auth, createUserWithEmailAndPassword, sendEmailVerification} from "./firebase.js"
import "https://code.jquery.com/jquery-3.6.0.min.js";

// Email
const isValidAccount = (email, password) => {
    const emailPattern = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$/;
    const passwordPattern = /^[a-zA-Z0-9]{6,16}$/;


    if (!emailPattern.test(email)) {
        console.log(email);
        window.alert("請輸入正確的電子信箱");
        return false;
    }

    if (!passwordPattern.test(password)) {
        window.alert("輸入的密碼要是6~16碼的英數字");
        return false;
    }

    return true;
};
$(document).ready(() => {
    $('#register-button').on('click', () => {
       if($('#privacy-checkbox').prop('checked')){
           const email = $('#email').val();
           const password = $('#password').val();
           console.log(email);
           if (isValidAccount(email, password)) {
               createUserWithEmailAndPassword(auth, email, password)
                   .then((userCredential) => {
                       sendEmailVerification(userCredential.user)
                           .then(() => {
                               window.alert('驗證信已送出')
                               window.location.href = '/Login';
                           })
                           .catch(error => {
                               console.log(error);
                           })
                   })
                   .catch(error => {
                       console.log(error);
                       window.alert(error);
                   })
           }
       }else{
           window.alert('尚未確認隱私條款');
       }
    });


})