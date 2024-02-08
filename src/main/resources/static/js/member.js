import {auth, onAuthStateChanged, signOut} from './firebase.js';
import "https://code.jquery.com/jquery-3.6.0.min.js";
import {showToast} from "./jquery.toast.js";

$(document).ready(() => {
    onAuthStateChanged(auth, (user => {
            if (user) {
                user.getIdToken()
                    .then(idToken => {
                        showInfoFromBack(idToken);
                        showCoupon(idToken);
                        showOrderStatus(idToken);
                        resetOrder()
                        showOrders(idToken,1);
                        selectStatus(idToken);

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

    $('#pick-shop').prop('href','https://emap.presco.com.tw/c2cemap.ashx?eshopid=870&&servicetype=1&url=http://localhost:8080/cvs_callback')





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
                $('#address').prop('value',data.address);

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
function showOrders(idToken,status,start){
    fetch('/showOrders',{
        method: 'POST',
        headers: {'Content-Type': 'application/json;charset=utf-8'},
        body: JSON.stringify({"idToken": idToken,"status": status,"start": start})
    }).then(res=>res.json())
        .then(data=>data.forEach((orderItem,index)=>{
            $(`#commodity${index}`).text('商品名: ' + orderItem.productName);
            $(`#quantity${index}`).text('數量: ' + orderItem.quantity);
            $(`#model${index}`).text('規格:'+orderItem.model);
            $(`#img${index}`).prop('src',orderItem.image);
        }));
}
function showOrderStatus(idToken) {
    fetch('/showOrderStatus', {
        method: 'POST',
        headers: {'Content-Type': 'application/json;charset=utf-8'},
        body: JSON.stringify({"idToken": idToken})
    })
        .then(res => res.json())
        .then(data=>data.forEach((order, index) => {
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
        $(`#model${i}`).text('規格: ');
        $(`#img${i}`).prop('src','./images/coupon3.png');
        $(`#img${i}`).prop('alt','');
    }
}

function selectStatus(idToken){
    let status;
    $('#status1').on('click', () => {
        resetOrder();
        status=1;
        pageSelector(idToken,status);
    });
    $('#status2').on('click', () => {
        resetOrder();
        status=2;
        pageSelector(idToken,status);
    });
    $('#status3').on('click', () => {
        resetOrder();
        status=3;
        pageSelector(idToken,status);
    });

}

function pageSelector(idToken,status){
    let page = 1;
    const pageSize = 3;
    const start = (page-1)*pageSize;
    showOrders(idToken,status,start);

    $('#first').on('click',()=>{
        page = 1;
        console.log(status);
        const start = (page-1)*pageSize;
        showOrders(idToken,status,start);
    })
    $('#second').on('click',()=>{
        page = 2;
        console.log(status);
        const start = (page-1)*pageSize;
        showOrders(idToken,status,start);
    })
    $('#third').on('click',()=>{
        page = 3;
        const start = (page-1)*pageSize;
        showOrders(idToken,status,start);
    })
    $('#prev').on('click',()=>{
        if(page>0){
            page--;
            const start = (page-1)*pageSize;
            showOrders(idToken,status,start);
        }else{
            page = 1;
            const start = (page-1)*pageSize;
            showOrders(idToken,status,start);
        }
    })
    $('#next').on('click',()=>{
        if(page<3){
            page++;
            const start = (page-1)*pageSize;
            showOrders(idToken,status,start);
        }else{
            page=3;
            const start = (page-1)*pageSize;
            showOrders(idToken,status,start);
        }
    })
}


function sentStatusAndPage(idToken){

}
