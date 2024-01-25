import{sendPasswordResetEmail,auth} from "./firebase.js";
import "https://code.jquery.com/jquery-3.6.0.min.js";

$(document).ready(()=>{
    $('#verify').on('click',()=>{
        const email = $('#email').val();
        sendPasswordResetEmail(auth,email)
            .then(()=>{
                console.log('ok');
            }).catch(error=>console.log(error))
    })


})

