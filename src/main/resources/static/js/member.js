import {auth, onAuthStateChanged} from './firebase.js';
import "https://code.jquery.com/jquery-3.6.0.min.js";


$(document).ready(() => {
    onAuthStateChanged(auth, (user => {
            if (user) {
                user.getIdToken()
                    .then(idToken => {
                        showInfoFromBack(idToken);
                        resetOrder()
                        showOrder(idToken);
                        showOrderQuantity(idToken)
                        $('#status1').on('click', () => {
                            resetOrder()
                            showOrder(idToken, 1);
                            showOrderQuantity(idToken, 1)
                        });
                        $('#status2').on('click', () => {
                            resetOrder()
                            showOrder(idToken, 2);
                            showOrderQuantity(idToken, 2)
                        });
                        $('#status3').on('click', () => {
                            resetOrder()
                            showOrder(idToken, 3);
                            showOrderQuantity(idToken, 3)
                        });
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
                            setInfo(idToken, selectedGender, birthday, address);
                        })
                        .then(data => {
                            console.log(data)
                        })
                }
            })
        )
    });


})

function showInfoFromBack(idToken) {
    fetch('/showInfo', {
        method: 'POST',
        headers: {'Content-Type': 'application/json;charset=utf-8'},
        body: JSON.stringify({"idToken": idToken})
    })
        .then(res => res.json())
        .then(data => {
            $('#email').prop('value', data.email);
            $('input[name="gender"][value="' + data.gender + '"]').prop('checked', true);
            $('#birthday').prop('value', data.birthday);
            // $('#test').prop('src',data.picture);
        })
}

function setInfo(idToken, gender, birthday, address) {
    fetch('/setInfo', {
        method: 'POST',
        headers: {'Content-Type': 'application/json;charset=utf-8'},
        body: JSON.stringify({"idToken": idToken, "gender": gender, "birthday": birthday, "address": address})
    })
        .then(res => res.json())
        .then(data => console.log(data))
        .catch(error => console.log(error))
}

function showOrder(idToken, status) {
    fetch('/showOrderName', {
        method: 'POST',
        headers: {'Content-Type': 'application/json;charset=utf-8'},
        body: JSON.stringify({"idToken": idToken, "status": status})
    })
        .then(res => res.json())
        .then(data => data.forEach((orderItem, index) => {
                $(`#commodity${index}`).text('商品名: ' + orderItem);
            })
        )
        .catch(error => console.log(error))
}

function showOrderQuantity(idToken, status) {
    fetch('/showOrderQuantity', {
        method: 'POST',
        headers: {'Content-Type': 'application/json;charset=utf-8'},
        body: JSON.stringify({"idToken": idToken, "status": status})
    })
        .then(res => res.json())
        .then(data => data.forEach((quantity, index) => {
                $(`#quantity${index}`).text('數量: ' + quantity);
            })
        )
        .catch(error => console.log(error))
}

function resetOrder() {
    for (let i = 0; i < 99; i++) {
        $(`#commodity${i}`).text('商品名: ')
        $(`#quantity${i}`).text('數量: ');
    }
}




