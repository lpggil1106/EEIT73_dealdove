import {auth, onAuthStateChanged} from './firebase.js';
import "https://code.jquery.com/jquery-3.6.0.min.js";


$(document).ready(() => {
    onAuthStateChanged(auth, (user => {
            if (user) {
                user.getIdToken()
                    .then(idToken => {
                        showInfoFromBack(idToken);
                        showCoupon(idToken);
                        showOrderStatus(idToken);
                        resetOrder()
                        showOrder(idToken);
                        $('#status1').on('click', () => {
                            resetOrder()
                            showOrder(idToken, 1);
                        });
                        $('#status2').on('click', () => {
                            resetOrder()
                            showOrder(idToken, 2);
                        });
                        $('#status3').on('click', () => {
                            resetOrder()
                            showOrder(idToken, 3);
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
        .then(data =>data.forEach((data)=>{
                $('#email').prop('value', data.email);
                $('input[name="gender"][value="' + data.gender + '"]').prop('checked', true);
                $('#birthday').prop('value', data.birthday);

        })
        )
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
        .then(data=>data.forEach((orderItem, index) => {
            console.log(orderItem.productName);
                $(`#commodity${index}`).text('商品名: ' + orderItem.productName);
                $(`#quantity${index}`).text('數量: ' + orderItem.orderQuantity);
                $(`#img${index}`).prop('src',orderItem.productImage);
                // console.log( $(`#quantity${index}`).text());
            })
        )
        .catch(error => console.log(error))
}
function showOrderStatus(idToken) {
    fetch('/showOrderStatus', {
        method: 'POST',
        headers: {'Content-Type': 'application/json;charset=utf-8'},
        body: JSON.stringify({"idToken": idToken})
    })
        .then(res => res.json())
        .then(data=>data.forEach((order, index) => {
            console.log(order.image);
                if(order.Status==='1'){
                    const status = '待出貨';
                    $(`#orderStatus${index}`).text('訂單狀態 :'+status);
                }else if (order.Status==='2'){
                    const status = '待收貨'
                    $(`#orderStatus${index}`).text('訂單狀態 :'+status);
                }else if (order.Status==='3'){
                    const status = '已完成'
                    $(`#orderStatus${index}`).text('訂單狀態 :'+status);
                }
                $(`#orderImg${index}`).prop('src',order.image);
            })
        )
        .catch(error => console.log(error))
}

function showCoupon(idToken) {
    fetch('/showCoupon',{
        method: 'POST',
        headers: {'Content-Type': 'application/json;charset=utf-8'},
        body: JSON.stringify({"idToken": idToken})
    }).then(res=>res.json())
        .then(data=>data.forEach((data,index)=>{
            $(`#desc${index}`).text(data);
            if(index>=4){
                $('.bottom-section').append(
                    `<div class="coupon-block"> <img src="./images/coupon2.png" alt="圖片 1"> <p id="desc${index}"></p> </div>`
                )
                console.log(index+"in if");
                $(`#desc${index}`).text(data);
            }
        }))
}


function resetOrder() {
    for (let i = 0; i < 99; i++) {
        $(`#commodity${i}`).text('商品名: ')
        $(`#quantity${i}`).text('數量: ');
        $(`#img${i}`).prop('src','./images/coupon3.png');
        $(`#img${i}`).prop('alt','');
    }
}




