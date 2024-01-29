import {auth, onAuthStateChanged} from './firebase.js';
import "https://code.jquery.com/jquery-3.6.0.min.js";


$(document).ready(() => {
    onAuthStateChanged(auth, (user => {
        if (user) {
            user.getIdToken()
                .then(idToken => {
                    // const selectedGender = $('input[name="gender"]:checked').val();
                    showInfoFromBack(idToken)
                })
        }
        })
    );
    $('#update').on('click', function () {
        onAuthStateChanged(auth, (user => {
                if (user) {
                    user.getIdToken()
                        .then(idToken => {
                            console.log(idToken);
                            const selectedGender = $('input[name="gender"]:checked').val();
                            const birthday = $('#birthday').val();
                            const address = $('#address').val();
                            setInfo(idToken, selectedGender,birthday,address);
                        })
                        .then(data => {
                            console.log(data)
                        })
                }
            })
        )


    });
})
function showInfoFromBack(idToken){
    fetch('/showInfo',{
        method:'POST',
        headers:{'Content-Type': 'application/json;charset=utf-8'},
        body:JSON.stringify({"idToken":idToken})
    })
        .then(res=>res.json())
        .then(data=>{
            $('#email').prop('value',data.email);
            $('input[name="gender"][value="' + data.gender + '"]').prop('checked', true);
            $('#birthday').prop('value',data.birthday);
        })
}

function setInfo(idToken,gender,birthday,address){
    fetch('/setInfo',{
        method:'POST',
        headers:{'Content-Type': 'application/json;charset=utf-8'},
        body:JSON.stringify({"idToken":idToken,"gender":gender,"birthday":birthday,"address":address})
    })
        .then(res=>res.json())
        .then(data=>console.log(data))
        .catch(error=>console.log(error))
}





