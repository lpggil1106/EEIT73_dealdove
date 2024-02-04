import {auth, onAuthStateChanged, signOut} from "./firebase.js";
onAuthStateChanged(auth, (user => {
    console.log("開始")
    if (user) {
        console.log('有user'+user.getIdToken())
        user.getIdToken()
            .then(idToken => {
                fetchOrder(idToken);
            })
    }else{
        console.log('no user')
    }
}))

function fetchOrder(idToken) {
    fetch('/getOrderBySellerID',{
        method: 'POST',
        headers: {'Content-Type': 'application/json;charset=utf-8'},
        body: JSON.stringify({"idToken": idToken})
    })
        .then(response => response.json())
        .then(groups => {
            localStorage.setItem('groups', JSON.stringify(groups));
            console.log('fetchOrder');
            console.log('groups',groups);
            Object.entries(groups).forEach(([sellerID, products],index) => {
                console.log('sellerID', sellerID);
                console.log('index', index);
                generateOrderItems(products, index);
                console.log('products', products);
            });
        })
        .catch(error => {
            console.error('Error fetching products:', error);
            console.log(error.message);
        });
}
// function show(status) {
//     var form = JSON.parse(localStorage.getItem('groups'));
//     console.log(form);
//     const orderContainer = document.getElementById('orderContainer');
//     orderContainer.innerHTML = "";
//
//     const orderSelectionBar = document.createElement('div');
//     orderSelectionBar.classList.add('order-selection-bar');
//     orderSelectionBar.innerHTML = `
//                     <ul>
//                         <li>商品</li>
//                         <li style="margin-right:10vw;padding-left:5vw">型號</li>
//                         <li>數量</li>
//                     </ul>
//                 `;
//     orderContainer.appendChild(orderSelectionBar);
//     if(status === 0){
//         console.log('status 0')
//         Object.entries(form).forEach(([sellerID, products], index) => {
//             generateOrderItems(products, index);
//         });
//     }else{
//         console.log('status else')
//         Object.entries(form).forEach(([sellerID, products], index) => {
//             if(products[0].orderStatus === status){
//                 generateOrderItems(products, index);
//             }
//         });
//     }
//
// }
    function generateOrderItems(orders,index){
        console.log('generateOrderItems');
        const orderContainer = document.getElementById('orderContainer');
        const cartItemsContainer = document.createElement(`div`);
        cartItemsContainer.classList.add(`container`);
        cartItemsContainer.style.maxWidth = '83vw';
        cartItemsContainer.style.paddingTop = '0.5vw';
        const statusCode = 2;
        let statusText;

        switch (orders[0].orderStatus) {
            case 1:
                statusText = "待出貨";
                break;
            case 2:
                statusText = "運送中";
                break;
            case 3:
                statusText = "已完成";
                break;
            default:
                statusText = "未知狀態";
        }

        cartItemsContainer.innerHTML = `<div class="cart-item-header">
                    <div class="user-details">
                        <div class="user-avatar"><img src="/images/使用者頭像.png" alt="error"></div>
                        <div class="user-name">${orders[0].userName}</div>
                        <a href="">
                            <svg xmlns="http://www.w3.org/2000/svg" width="56" height="55" viewBox="0 0 56 55"
                                 fill="none">
                                <path d="M39.0488 4.5835H16.1322C9.80716 4.5835 4.67383 9.69391 4.67383 15.996V29.7002V31.9918C4.67383 38.2939 9.80716 43.4043 16.1322 43.4043H19.5697C20.1884 43.4043 21.0134 43.8168 21.403 44.321L24.8405 48.8814C26.353 50.8981 28.828 50.8981 30.3405 48.8814L33.778 44.321C34.2134 43.7481 34.9009 43.4043 35.6113 43.4043H39.0488C45.3738 43.4043 50.5072 38.2939 50.5072 31.9918V15.996C50.5072 9.69391 45.3738 4.5835 39.0488 4.5835ZM18.4238 27.5002C17.1405 27.5002 16.1322 26.4689 16.1322 25.2085C16.1322 23.9481 17.1634 22.9168 18.4238 22.9168C19.6842 22.9168 20.7155 23.9481 20.7155 25.2085C20.7155 26.4689 19.7072 27.5002 18.4238 27.5002ZM27.5905 27.5002C26.3072 27.5002 25.2988 26.4689 25.2988 25.2085C25.2988 23.9481 26.3301 22.9168 27.5905 22.9168C28.8509 22.9168 29.8822 23.9481 29.8822 25.2085C29.8822 26.4689 28.8738 27.5002 27.5905 27.5002ZM36.7572 27.5002C35.4738 27.5002 34.4655 26.4689 34.4655 25.2085C34.4655 23.9481 35.4967 22.9168 36.7572 22.9168C38.0176 22.9168 39.0488 23.9481 39.0488 25.2085C39.0488 26.4689 38.0405 27.5002 36.7572 27.5002Z"
                                      fill="#A2CAD3"/>
                            </svg>
                        </a>
                    </div>
                    <div class="order-number">運送狀態: ${statusText}</div>
                    <div class="order-number">總價:${orders[0].totalPrice}</div>
                    <div class="order-number">地址:${orders[0].shippingAddress}</div>
                    <div class="order-number">訂單編號: ${orders[0].orderID}</div>
                </div>`;

        orders.forEach((order) => {
            const cartItem = document.createElement('div');
            cartItem.classList.add('cart-item');
            const {userName, buyerID, orderID, productName, quantity, model, totalPrice ,orderStatus,shippingAddress, coverImageURL} = order;
            cartItem.innerHTML = `
                <img src="${coverImageURL}" alt="Product Image">
                    <div class="item-name">
                        <p>${productName}</p>
                    </div>
                    <div class="item-product-model" style="padding-left:4vw;margin-right:4vw">
                        <p>${model}</p>
                    </div>
                    <div class="item-product-unit">
                        <p>${quantity}</p>
                    </div>`;
            cartItemsContainer.appendChild(cartItem);
            orderContainer.appendChild(cartItemsContainer);
        })

    }
