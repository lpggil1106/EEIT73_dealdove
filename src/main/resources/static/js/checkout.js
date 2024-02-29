import {auth, onAuthStateChanged} from "./firebase.js"
import "https://code.jquery.com/jquery-3.6.0.min.js";
import "https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js";
import "https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js";
import "https://ecpg-stage.ecpay.com.tw/Scripts/sdk-1.0.0.js?t=20210121100116";

$(document).ready(() => {
    window.onload = function () {
        var urlParams = new URLSearchParams(window.location.search);
        var storename = urlParams.get('storename');
        if (storename) {
            document.getElementById('shippingAddress').value = decodeURIComponent(storename);
            document.getElementById('shippingAddress').innerText = decodeURIComponent(storename);
        }
    };
    onAuthStateChanged(auth, user => {
        if (user) {
            user.getIdToken()
                .then(idToken => {
                    console.log(idToken)
                    fetch(`/09_checkoutPage/shoppingCart/cartItems`, {
                        method: 'POST',
                        headers: {'Content-Type': 'application/json'},
                        body: JSON.stringify({'idToken': idToken})
                    })
                        .then(response => response.json())
                        .then(cartItems => {
                            // 渲染購物車項目
                            renderCartItems(cartItems);
                        })
                        .catch(error => console.error('Error:', error));
                })
        } else {
            console.log("用戶未登錄");
        }
    });

    // 為貨到付款添加監聽器
    $('#cash').on('change', () => {
        if (this.checked) {
            $('#payButtonCash').prop('style', 'block');
            $('#payButtonEcpay').prop('style', 'none');
        }
    });

    // 為綠界支付添加監聽器
    $('#ecpayment').on('change', () => {
        if (this.checked) {
            $('#payButtonEcpay').prop('style', 'block');
            $('#payButtonCash').prop('style', 'none');
        }
    });
})
// 選擇商品函數by 沈東毅
const selectedItems = localStorage.getItem('selectedItems')
const itemsArray = JSON.parse(selectedItems);

function getProductImages(productID) {
    return fetch(`/09_checkoutPage/${productID}/images`)
        .then(response => {
            if (response.ok) {
                return response.json();
            }
            throw new Error('Failed to fetch product details');
        })
        .then(images => {
            return images; // 直接返回字符串
        })
        .catch(error => console.error('Error:', error));
}

// 獲取產品名稱的函數
function getProductName(productID) {
    return fetch(`/09_checkoutPage/product/details/${productID}`)
        .then(response => {
            if (response.ok) {
                return response.text();
            }
            throw new Error('Failed to fetch product details');
        })
        .then(productName => {
            return productName; // 直接返回字符串
        })
        .catch(error => console.error('Error:', error));
}

function renderCartItems(cartItems) {
    const cartContainer = document.querySelector('.container');
    cartContainer.innerHTML = ''; // 清空現有內容
    let totalQuantity = 0; // 初始化總數量累加器
    let totalAmount = 0; // 初始化總金額累加器


    // 使用 Promise.all 確保所有異步操作完成
    const promises = cartItems.map(item => {
        return getProductName(item.productID).then(productName => {
            return getProductImages(item.productID).then(images => {
                if (containedInArray(itemsArray, item.shoppingCartItemID)) {

                    const imageSrc = images.length > 0 ? images[0] : 'default-image-path';
                    const totalPrice = item.price * item.quantity;
                    totalQuantity += item.quantity; // 累加商品總數量
                    totalAmount += totalPrice; // 累加商品總金額

                    const cartItemElement = document.createElement('div');
                    cartItemElement.classList.add('cart-item');
                    cartItemElement.innerHTML = `
                        <img src="${imageSrc}" alt="Product Image">
                        <div class="item-name">
                            <p>${productName}</p>
                        </div>
                        <div class="item-model">
                            <p>${item.models}</p>
                        </div>
                        <div class="item-unit">
                            <p>${item.price}</p>
                        </div>
                        <div class="item-quantity">
                            <p>${item.quantity}</p>
                        </div>
                        <div class="item-total">
                            <p>$${totalPrice.toFixed(2)}</p>
                        </div>
                        `;
                    cartContainer.appendChild(cartItemElement);
                }
            });
        });
    });

    // 等待所有商品处理完成后更新总数量和总金额
    Promise.all(promises).then(() => {
        document.getElementById('checkOutQuantity').textContent = totalQuantity; // 更新总数量
        document.getElementById('checkOutTotal').textContent = `${totalAmount}`; // 更新总金额

        // 更新隐藏的 input 字段，以便可以提交总价
        document.getElementById('checkOutTotalInput').value = totalAmount;
    });

}

function containedInArray(array, value) {
    for (let i = 0; i < array.length; i++) {
        if (array[i] === value) {
            return true;
        }
    }
    return false;
}

// 監聽綠界支付選項的變化
document.getElementById('ecpayment').addEventListener('change', function () {
    if (this.checked) {
        // 當選中綠界支付時，設置隱藏輸入字段的值為1
        document.getElementById('paymentInput').value = "1";
        document.getElementById('statusInput').value = "1";
    }
});

// 監聽貨到付款選項的變化
document.getElementById('cash').addEventListener('change', function () {
    if (this.checked) {
        // 當選中貨到付款時，設置隱藏輸入字段的值為2
        document.getElementById('paymentInput').value = "2";
        document.getElementById('statusInput').value = "2";
    }
});

function redirectToPayment() {
    fetch('/ecpayCheckout', {
        method: 'POST'
    }).then(res => res.text())
        .then(data => {
                var div = document.createElement('div');
                div.innerHTML = data;

                // 將 div 中的 form 元素添加到 body 中
                var form = div.querySelector('form');
                if (form) {
                    document.body.appendChild(form);
                    // 提交表單
                    form.submit();
                } else {
                    console.error('Form element not found in HTML content.');
                }
            }
        )
        .catch(error => {
            console.error('Fetch error:', error);
        });
}

document.getElementById('payButtonEcpay').addEventListener('click', function (event) {
    event.preventDefault(); // 阻止表單默認提交行為

    const buyerNote = document.getElementById('buyerNote').value;
    const shippingAddress = document.getElementById('shippingAddress').value;
    const checkOutTotalInput = document.getElementById('checkOutTotalInput').value;
    const paymentInput = document.getElementById('paymentInput').value;
    const statusInput = document.getElementById('statusInput').value;
    const userIDInput = document.getElementById('userIDInput').value;

    // 創建提交到後端的數據對象
    const orderData = {
        buyerComment: buyerNote,
        shippingAddress: shippingAddress,
        totalPrice: checkOutTotalInput,
        paymentID: paymentInput,
        orderStatus: statusInput,
        buyerID: userIDInput,

    };

// 使用 fetch API 發送數據到後端
    fetch('/09_checkoutPage/submitOrder', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(orderData),
    })
        .then(response => response.json())
        .then(data => {
            console.log('Order submitted successfully', data);
        })
        .catch((error) => {
            console.error('Error:', error);
        });
});

function redirectToPaymentCash() {
    window.location.href = '/Dealdove';
}


document.getElementById('payButtonCash').addEventListener('click', function (event) {
    event.preventDefault(); // 阻止表單默認提交行為

    const buyerNote = document.getElementById('buyerNote').value;
    const shippingAddress = document.getElementById('shippingAddress').value;
    const checkOutTotalInput = document.getElementById('checkOutTotalInput').value;
    const paymentInput = document.getElementById('paymentInput').value;
    const statusInput = document.getElementById('statusInput').value;
    const userIDInput = document.getElementById('userIDInput').value;


// 創建提交到後端的數據對象
    const orderData = {
        buyerComment: buyerNote,
        shippingAddress: shippingAddress,
        totalPrice: checkOutTotalInput,
        paymentID: paymentInput,
        orderStatus: statusInput,
        buyerID: userIDInput,
    };

// 使用 fetch API 發送數據到後端
    fetch('/09_checkoutPage/submitOrder', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(orderData),
    })
        .then(response => response.json())
        .then(data => {
// 處理響應數據
            console.log('Order submitted successfully', data);
        })
        .catch((error) => {
// 處理錯誤情況
            console.error('Error:', error);
        });
});


onAuthStateChanged(auth, user => {
    if (user) {
        const userID = user.uid;
        document.getElementById('userIDInput').value = userID;
    } else {
        console.log("未登錄");
    }
});


window.onload = function () {
    // 獲取 radio button 和按鈕元素
    var cashRadio = document.getElementById('cash');
    var ecpayRadio = document.getElementById('ecpayment');
    var payButtonCash = document.getElementById('payButtonCash');
    var payButtonEcpay = document.getElementById('payButtonEcpay');

    cashRadio.addEventListener('change', function () {
        if (this.checked) {
            payButtonCash.style.display = 'block';
            payButtonEcpay.style.display = 'none';
        }
    });

    ecpayRadio.addEventListener('change', function () {
        if (this.checked) {
            payButtonEcpay.style.display = 'block';
            payButtonCash.style.display = 'none';
        }
    });
};

document.addEventListener('DOMContentLoaded', function () {
    const couponContainer = document.querySelector('.container.coupon-container');

    auth.onAuthStateChanged(user => {
        if (user) {
            user.getIdToken().then(token => {
                fetch(`/09_checkoutPage/userCoupons`, {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify({token})
                })
                    .then(response => response.json())
                    .then(coupons => {
                        if (Array.isArray(coupons)) {
                            const detailsPromises = coupons.map((coupon, index) => { // 確保這里傳遞了index參數
                                if (coupon.couponBaseID) {
                                    return getCouponDetails(coupon.couponBaseID)
                                        .then(couponBase => createCouponElement(couponBase, index));
                                } else {
                                    console.error('優惠券沒有有效的 couponBaseID', coupon);
                                    return null;
                                }
                            });

                            Promise.all(detailsPromises).then(elements => {
                                elements.forEach(element => {
                                    if (element) {
                                        couponContainer.appendChild(element);
                                    }
                                });
                            });
                        } else {
                            console.error('返回的優惠券數據不是一個數組', coupons);
                        }
                    })
                    .catch(error => console.error('Error:', error));
            });
        } else {
            console.log("用戶未登錄");
        }
    });
});

function getCouponDetails(couponBaseID) {
    return fetch(`/09_checkoutPage/couponBaseDetails/${couponBaseID}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
            return data;
        })
        .catch(error => {
            console.error('Error fetching coupon base details:', error);
        });
}

// 假設你已經有一個函數來初始化或更新購物車項目和總金額
function initializeOrUpdateCart() {
    // 初始化或更新購物車總金額顯示邏輯
    // 假設這里你已經計算了不包含折扣的總金額並更新了 checkOutTotal 和 checkOutTotalInput 的值
    const totalAmountWithoutDiscount = parseFloat(document.getElementById('checkOutTotal').textContent);
    document.getElementById('checkOutTotalInput').value = totalAmountWithoutDiscount;
    updateTotalAmountWithDiscount(); // 調用更新總金額（包含折扣）的函數
}

function updateTotalAmountWithDiscount() {
    // 獲取原始總金額和折扣金額
    const totalAmountWithoutDiscount = parseFloat(document.getElementById('checkOutTotalInput').value);
    const discountAmount = parseFloat(document.getElementById('discountInput').value);

    // 計算包含折扣的新總金額
    const totalAmountWithDiscount = totalAmountWithoutDiscount - discountAmount;

    // 更新總金額顯示
    document.getElementById('checkOutTotal').textContent = totalAmountWithDiscount;

    // 重要：更新隱藏輸入字段以反映折扣後的總金額，確保這是傳遞到數據庫的金額
    document.getElementById('checkOutTotalInput').value = totalAmountWithDiscount;
}

function createCouponElement(couponBase, index) {
    let targetContainer = document.getElementById("couponContainer");

    // 確保每行顯示的優惠券數量（例如：每行3個）
    const couponsPerRow = 4;
    let couponRow;
    if (index % couponsPerRow === 0) {
        couponRow = document.createElement("div");
        couponRow.className = "coupon-row";
        couponRow.style.display = "flex"; // 使用Flex布局
        couponRow.style.justifyContent = "space-around"; // 使元素在行中均匀分布
        targetContainer.appendChild(couponRow);
    } else {
        couponRow = targetContainer.querySelector(".coupon-row:last-child");
    }

    const couponCard = document.createElement("div");

    couponCard.className = "coupon-card";
    couponCard.style.display = "flex";
    couponCard.style.alignItems = "center";
    couponCard.style.margin = "10px";
    couponCard.style.padding = "10px";
    couponCard.style.boxShadow = "0 2px 4px rgba(0,0,0,0.1)";
    couponCard.style.cursor = "pointer";

    couponCard.addEventListener('click', function () {
        // 清除之前選中的優惠券的選中狀態
        document.querySelectorAll('.coupon-card.selected').forEach(function (card) {
            card.classList.remove('selected');
        });

        // 將當前優惠券設為選中狀態
        this.classList.add('selected');

        // 更新折扣金額顯示
        const discountAmountEl = document.getElementById('discountAmount');
        discountAmountEl.textContent = couponBase.discount; // 格式化折扣金额，保留两位小数

        // 更新隐藏字段或其他需要使用折扣值的地方
        document.getElementById('discountInput').value = couponBase.discount;

        // 重新計算並更新總金額（包含折扣）
        updateTotalAmountWithDiscount();
    });

    const img = document.createElement("img");
    img.src = "./images/coupon2.png";
    img.style.width = "100px"; // 圖片大小設定
    img.style.height = "auto";
    img.style.marginRight = "20px"; // 圖片和詳情之間的間隔
    couponCard.appendChild(img);

    const details = document.createElement("div");
    details.style.marginLeft = "1vw";
    details.className = "product-details";

    const couponCode = document.createElement("div");
    couponCode.innerText = couponBase.couponName;
    details.appendChild(couponCode);

    const couponNumber = document.createElement("p");
    couponNumber.innerText = "折扣碼 " + couponBase.couponCode;
    details.appendChild(couponNumber);

    const productPricing = document.createElement("div");
    productPricing.className = "product-pricing";

    const conditions = document.createElement("div");
    conditions.innerText = "使用條件" + couponBase.minimumAmount + "-" + couponBase.discount;
    details.appendChild(conditions);

    const expirationDate = new Date(couponBase.expirationDate);
    const formattedDate = `${expirationDate.getFullYear()}-${String(expirationDate.getMonth() + 1).padStart(2, '0')}-${String(expirationDate.getDate()).padStart(2, '0')}  ${String(expirationDate.getHours()).padStart(2, '0')}:${String(expirationDate.getMinutes()).padStart(2, '0')}`;
    const exdate = document.createElement("p");
    exdate.innerText = "有效期限至 " + formattedDate;
    exdate.style.marginTop = "1vw";
    exdate.style.fontSize = "1vw";
    productPricing.appendChild(exdate);

    couponCard.appendChild(details);
    couponRow.appendChild(couponCard);
}

document.addEventListener('DOMContentLoaded', function () {
    initializeOrUpdateCart();
});


