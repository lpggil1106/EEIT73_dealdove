import {auth, onAuthStateChanged} from './firebase.js';
import "https://code.jquery.com/jquery-3.6.0.min.js";

        onAuthStateChanged(auth, (user => {
            console.log("開始")
            if (user) {
                console.log('有user'+user.getIdToken())
                user.getIdToken()
                    .then(idToken => {
                        fetchProducts(idToken);
                        localStorage.setItem(`selectedItems`,"[]");
                    })
            }else{
                console.log('no user')
            }
        }))

function fetchProducts(idToken) {
    fetch('/api/shoppingCart/getCartItems',{
        method: 'POST',
        headers: {'Content-Type': 'application/json;charset=utf-8'},
        body: JSON.stringify({"idToken": idToken})
    })
        .then(response => response.json())
        .then(groups => {
            console.log('fetchProducts123123');
            console.log('groups',groups);
            Object.entries(groups).forEach(([sellerID, products],index) => {
                console.log('sellerID', sellerID);
                console.log('index', index);
                generateProductItems(products, index);
                console.log('products', products);
            });
        })
        .catch(error => {
            console.error('Error fetching products:', error);
            console.log(error.message); // 這裡添加這一行
        });
}

function generateProductItems(products,index) {
    console.log('generateProductItems');
            const checkoutContainer = document.getElementById('cartGroup');
    const cartItemsContainer = document.createElement(`div`);
    cartItemsContainer.classList.add(`container`);
    cartItemsContainer.innerHTML = `<div class="cart-item-head">
        <input type="checkbox" id="select${index}" >
        <div class="item-info" style="padding-left:0;">
            <p>賣家:${products[0].sellerName}</p>
        </div>
        <div class="item-name-shopping"></div>
        <div class="item-model" style="width:16vw;margin-right:4vw;padding-left:0">
            <p>商品規格</p>
        </div>
        <div class="item-unit-head" style="width:8vw;margin-right:0vw;padding-left:2vw">
            <p>商品單價</p>
        </div>
        <div class="item-quantity-head" style="width:16vw;margin-right:0vw">
            <p>下單數量</p>
        </div>
        <div class="item-total-head" style="width:16vw;margin-right:1.5vw">
            <p>價格總價</p>
        </div>
    </div>`;

    products.forEach((product) => {
        const cartItem = document.createElement('div');
        cartItem.classList.add('cart-item');
        // 這裡需要根據實際後端返回的商品資料結構來設定屬性
        const {coverImageURL, models, price, productName, quantity,shoppingCartItemID, sellerID,sellerName } = product;
        let total = quantity * price;
        cartItem.innerHTML = `
            <img src="${coverImageURL}" alt="Product Image">
            <div class="item-name" style="width:19vw">
                <p id="productName${shoppingCartItemID}">${productName}</p>
            </div>
            <div class="item-model">
                <p id="model${shoppingCartItemID}">${models}</p>
            </div>
            <div class="item-unit" style="padding-left:0">
                <p id="price${shoppingCartItemID}">${price}</p>
            </div>
            <div class="item-quantity-head" style="margin-bottom:1vw; margin-left:1vw">
                <div class="quantity-container">
                    <button class="function-button" onclick="decreaseQuantity(${shoppingCartItemID},${index})">-</button>
                    <input style="margin:0;" type="text" id="quantity${shoppingCartItemID}" class="quantity-input" value="${quantity}" readonly>
                    <button class="function-button" onclick="increaseQuantity(${shoppingCartItemID},${index})">+</button>
                </div>
            </div>
            <div class="item-total-head">
                <p id = "total_${index}_${shoppingCartItemID}">$${total}</p>
            </div>
            <button class="delete-button" onclick="deleteShoppingCartItem(${shoppingCartItemID})">刪除</button>
        `;

        // 將生成的商品項目加入到容器中
        cartItemsContainer.appendChild(cartItem);
        let container = document.getElementById('checkout');
        checkoutContainer.insertBefore(cartItemsContainer, checkoutContainer.firstChild);

        document.getElementById(`select${index}`).addEventListener('change', function() {
            updateCheckoutTotal();
            if (this.checked) {
                storeSelectedCartItemID(shoppingCartItemID);
            } else {
                removeSelectedCartItemID(shoppingCartItemID);
            }
        });
    });
}

function storeSelectedCartItemID(shoppingCartItemID) {
    let selectedItems = localStorage.getItem(`selectedItems`);
    selectedItems = selectedItems ? JSON.parse(selectedItems) : [];
    selectedItems.push(shoppingCartItemID);
    localStorage.setItem(`selectedItems`, JSON.stringify(selectedItems));
}

function removeSelectedCartItemID(shoppingCartItemID) {
    let selectedItems = localStorage.getItem(`selectedItems`);
    selectedItems = selectedItems ? JSON.parse(selectedItems) : [];
    const updatedItems = selectedItems.filter(id => id !== shoppingCartItemID);
    localStorage.setItem(`selectedItems`, JSON.stringify(updatedItems));
}

