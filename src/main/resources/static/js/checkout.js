import {auth,onAuthStateChanged} from "./firebase.js"
import "https://code.jquery.com/jquery-3.6.0.min.js";
import "https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js";
import "https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js";
import "https://ecpg-stage.ecpay.com.tw/Scripts/sdk-1.0.0.js?t=20210121100116";

$(document).ready(()=>{
    onAuthStateChanged(auth,user=>{
        if(user){
            user.getIdToken()
                .then(idToken=>{
                    console.log(idToken)
                fetch(`/09_checkoutPage/shoppingCart/cartItems`,{
                    method:'POST',
                    headers: {'Content-Type': 'application/json'},
                    body:JSON.stringify({'idToken':idToken})
                })
                    .then(response => response.json())
                    .then(cartItems => {
                        // 假设您有一个函数来渲染购物车项目
                        renderCartItems(cartItems);
                    })
                    .catch(error => console.error('Error:', error));
            })
        }else {
            console.log("用戶未登錄");
        }
    });

    // 为货到付款 radio button 添加 change 事件监听器
    $('#cash').on('change', ()=> {
        if (this.checked) {
            // 当选择货到付款时，改变按钮显示状态
            $('#payButtonCash').prop('style','block'); // 显示
            $('#payButtonEcpay').prop('style','none'); // 隐藏
        }
    });

    // 为绿界支付 radio button 添加 change 事件监听器
    $('#ecpayment').on('change', ()=> {
        if (this.checked) {
            // 当选择绿界支付时，改变按钮显示状态
            $('#payButtonEcpay').prop('style','block'); // 隐藏
            $('#payButtonCash').prop('style','none'); // 显示
        }
    });
})
// 選擇商品函數by 沈東毅

    const selectedItems = localStorage.getItem('selectedItems')
    const itemsArray = JSON.parse(selectedItems);
    // 当 DOM 完全加载后执行
    // function getCheckOutDetail(userID) {
    //     fetch(`/checkoutDetail/${userID}`)
    //         .then(response => response.json())
    //         .then(details => {
    //             return details; // 直接返回字符串
    //         })
    //         .catch(error => console.error('Error:', error));
    // }
    function getProductImages(productID) {
        return fetch(`/09_checkoutPage/${productID}/images`)
            .then(response => {
                if(response.ok) {
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
                if(response.ok) {
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
        const cartContainer = document.querySelector('.container'); // 确保选择正确的容器
        cartContainer.innerHTML = ''; // 清空现有内容
        let totalQuantity = 0; // 初始化总数量累加器
        let totalAmount = 0; // 初始化总金额累加器


        // 使用 Promise.all 确保所有异步操作完成
        const promises = cartItems.map(item => {
            return getProductName(item.productID).then(productName => {
                return getProductImages(item.productID).then(images => {
                    // const imageSrc = images.length > 0 ? images[0] : 'default-image-path';
                    // const totalPrice = item.price * item.quantity;
                    // totalQuantity += item.quantity; // 累加商品数量
                    // totalAmount += totalPrice; // 累加商品总价


                    if(containedInArray(itemsArray, item.shoppingCartItemID)){
                        const imageSrc = images.length > 0 ? images[0] : 'default-image-path';
                        const totalPrice = item.price * item.quantity;
                        totalQuantity += item.quantity; // 累加商品数量
                        totalAmount += totalPrice; // 累加商品总价

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


                //     const cartItemElement = document.createElement('div');
                //     cartItemElement.classList.add('cart-item');
                //     cartItemElement.innerHTML = `
                //     <img src="${imageSrc}" alt="Product Image">
                //     <div class="item-name">
                //         <p>${productName}</p>
                //     </div>
                //     <div class="item-model">
                //         <p>${item.models}</p>
                //     </div>
                //     <div class="item-unit">
                //         <p>${item.price}</p>
                //     </div>
                //     <div class="item-quantity">
                //         <p>${item.quantity}</p>
                //     </div>
                //     <div class="item-total">
                //         <p>$${totalPrice.toFixed(2)}</p>
                //     </div>
                // `;
                //     cartContainer.appendChild(cartItemElement);
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
        for(let i = 0; i < array.length; i++) {
            if(array[i] === value) {
                return true;
            }
        }
        return false;
    }
    // 监听綠界支付选项的变化
    document.getElementById('ecpayment').addEventListener('change', function() {
        if(this.checked) {
            // 当选中綠界支付时，设置隐藏输入字段的值为1
            document.getElementById('paymentInput').value = "1";
            document.getElementById('statusInput').value = "1";
        }
    });

    // 监听貨到付款选项的变化
    document.getElementById('cash').addEventListener('change', function() {
        if(this.checked) {
            // 当选中貨到付款时，设置隐藏输入字段的值为2
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

document.getElementById('payButtonEcpay').addEventListener('click', function(event) {
event.preventDefault(); // 阻止表单默认提交行为

    const buyerNote = document.getElementById('buyerNote').value;
    const shippingAddress = document.getElementById('shippingAddress').value;
    const checkOutTotalInput = document.getElementById('checkOutTotalInput').value;
    const paymentInput = document.getElementById('paymentInput').value;
    const statusInput = document.getElementById('statusInput').value;
    const userIDInput = document.getElementById('userIDInput').value;

// 创建提交到后端的数据对象
    const orderData = {
        buyerComment: buyerNote,
        shippingAddress: shippingAddress,
        totalPrice: checkOutTotalInput,
        paymentID: paymentInput,
        orderStatus: statusInput,
        buyerID: userIDInput,

    };

// 使用 fetch API 发送数据到后端
fetch('/09_checkoutPage/submitOrder', {
method: 'POST',
headers: {
'Content-Type': 'application/json',


},
body: JSON.stringify(orderData),
})
.then(response => response.json())
.then(data => {
// 处理响应数据
console.log('Order submitted successfully', data);
})
.catch((error) => {
// 处理错误情况
console.error('Error:', error);
});
});

    function redirectToPaymentCash() {
        window.location.href = '/Dealdove';
    }


    document.getElementById('payButtonCash').addEventListener('click', function(event) {
        event.preventDefault(); // 阻止表单默认提交行为

        const buyerNote = document.getElementById('buyerNote').value;
        const shippingAddress = document.getElementById('shippingAddress').value;
        const checkOutTotalInput = document.getElementById('checkOutTotalInput').value;
        const paymentInput = document.getElementById('paymentInput').value;
        const statusInput = document.getElementById('statusInput').value;
        const userIDInput = document.getElementById('userIDInput').value;


// 创建提交到后端的数据对象
        const orderData = {
            buyerComment: buyerNote,
            shippingAddress: shippingAddress,
            totalPrice: checkOutTotalInput,
            paymentID: paymentInput,
            orderStatus: statusInput,
            buyerID: userIDInput,
        };

// 使用 fetch API 发送数据到后端
        fetch('/09_checkoutPage/submitOrder', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(orderData),
        })
            .then(response => response.json())
            .then(data => {
// 处理响应数据
                console.log('Order submitted successfully', data);
            })
            .catch((error) => {
// 处理错误情况
                console.error('Error:', error);
            });
    });


    onAuthStateChanged(auth,user => {
        if (user) {
            const userID = user.uid; // uid 是用户的唯一标识符
            document.getElementById('userIDInput').value = userID;
        } else {
            // 用户未登录
            console.log("未登錄");
        }
    });


    window.onload = function() {
        // 获取 radio button 和按钮元素
        var cashRadio = document.getElementById('cash');
        var ecpayRadio = document.getElementById('ecpayment'); // 获取绿界支付的 radio button
        var payButtonCash = document.getElementById('payButtonCash');
        var payButtonEcpay = document.getElementById('payButtonEcpay');

        // 为货到付款 radio button 添加 change 事件监听器
        cashRadio.addEventListener('change', function() {
            if (this.checked) {
                // 当选择货到付款时，改变按钮显示状态
                payButtonCash.style.display = 'block'; // 显示
                payButtonEcpay.style.display = 'none'; // 隐藏
            }
        });

        // 为绿界支付 radio button 添加 change 事件监听器
        ecpayRadio.addEventListener('change', function() {
            if (this.checked) {
                // 当选择绿界支付时，改变按钮显示状态
                payButtonEcpay.style.display = 'block'; // 显示
                payButtonCash.style.display = 'none'; // 隐藏
            }
        });
    };

    document.addEventListener('DOMContentLoaded', function() {
        const couponContainer = document.querySelector('.container.coupon-container');

        auth.onAuthStateChanged(user => {
            if (user) {
                user.getIdToken().then(token => {
                    fetch(`/09_checkoutPage/userCoupons`, {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json',
                        },
                        body: JSON.stringify({ token })
                    })
                        .then(response => response.json())
                        .then(coupons => {
                            if (Array.isArray(coupons)) {
                                const detailsPromises = coupons.map((coupon, index) => { // 确保这里传递了index参数
                                    if (coupon.couponBaseID) {
                                        return getCouponDetails(coupon.couponBaseID)
                                            .then(couponBase => createCouponElement(couponBase, index)); // index 在这里被使用
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
                console.log(data); // 打印出响应数据来检查结构
                return data; // 确保这里返回的是正确的对象
            })
            .catch(error => {
                console.error('Error fetching coupon base details:', error);
            });
    }

    // 假设你已经有一个函数来初始化或更新购物车项目和总金额
    function initializeOrUpdateCart() {
        // 初始化或更新购物车总金额显示逻辑
        // 假设这里你已经计算了不包含折扣的总金额并更新了 checkOutTotal 和 checkOutTotalInput 的值
        const totalAmountWithoutDiscount = parseFloat(document.getElementById('checkOutTotal').textContent);
        document.getElementById('checkOutTotalInput').value = totalAmountWithoutDiscount;
        updateTotalAmountWithDiscount(); // 调用更新总金额（包含折扣）的函数
    }

    function updateTotalAmountWithDiscount() {
        // 获取原始总金额和折扣金额
        const totalAmountWithoutDiscount = parseFloat(document.getElementById('checkOutTotalInput').value);
        const discountAmount = parseFloat(document.getElementById('discountInput').value);

        // 计算包含折扣的新总金额
        const totalAmountWithDiscount = totalAmountWithoutDiscount - discountAmount;

        // 更新总金额显示
        document.getElementById('checkOutTotal').textContent = totalAmountWithDiscount;

        // 重要：更新隐藏输入字段以反映折扣后的总金额，确保这是传递到数据库的金额
        document.getElementById('checkOutTotalInput').value = totalAmountWithDiscount;
    }

    function createCouponElement(couponBase, index) {
        let targetContainer = document.getElementById("couponContainer");

        // 确保每行显示的优惠券数量（例如：每行3个）
        const couponsPerRow = 4;
        let couponRow;
        if (index % couponsPerRow === 0) {
            couponRow = document.createElement("div");
            couponRow.className = "coupon-row";
            couponRow.style.display = "flex"; // 使用Flex布局
            couponRow.style.justifyContent = "space-around"; // 子元素之间平均分配空间
            targetContainer.appendChild(couponRow);
        } else {
            couponRow = targetContainer.querySelector(".coupon-row:last-child");
        }

        const couponCard = document.createElement("div");
        couponCard.className = "coupon-card";
        couponCard.style.display = "flex";
        couponCard.style.alignItems = "center";
        couponCard.style.margin = "10px"; // 适当的外边距
        couponCard.style.padding = "10px"; // 适当的内边距
        couponCard.style.boxShadow = "0 2px 4px rgba(0,0,0,0.1)"; // 轻微的阴影效果
        couponCard.style.cursor = "pointer"; // 使其在hover时显示为指针

        couponCard.addEventListener('click', function() {
            // 清除之前选中的优惠券的选中状态
            document.querySelectorAll('.coupon-card.selected').forEach(function(card) {
                card.classList.remove('selected');
            });

            // 将当前优惠券设为选中状态
            this.classList.add('selected');

            // 更新折扣金额显示
            const discountAmountEl = document.getElementById('discountAmount');
            discountAmountEl.textContent = couponBase.discount; // 格式化折扣金额，保留两位小数

            // 更新隐藏字段或其他需要使用折扣值的地方
            document.getElementById('discountInput').value = couponBase.discount;

            // 重新计算并更新总金额（包含折扣）
            updateTotalAmountWithDiscount();
        });

        const img = document.createElement("img");
        img.src = "./images/coupon2.png";
        img.style.width = "100px"; // 固定图片大小
        img.style.height = "auto";
        img.style.marginRight = "20px"; // 图片和详情之间的间隔
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
        conditions.innerText = "使用條件" +couponBase.minimumAmount + "-" + couponBase.discount;
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

    document.addEventListener('DOMContentLoaded', function() {
        initializeOrUpdateCart();
        // 加载优惠券和其它初始化逻辑...
    });


