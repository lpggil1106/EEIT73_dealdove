import {auth, onAuthStateChanged} from './firebase.js';
import "https://code.jquery.com/jquery-3.6.0.min.js";

$(document).ready(() => {
    $('#addCart').on('click', () => {
        onAuthStateChanged(auth, (user => {
            if (user) {
                user.getIdToken()
                    .then(idToken => {
                        const productID = document.getElementById('productidmodel').innerText;
                        let models = firName + "," + secName;
                        const quantity = document.getElementById('quantityValue').value;
                        const price = document.getElementById('price').innerText;
                        addToCartButton(productID, models, quantity, idToken, price);
                    })
            }
        }));
    });

    function addToCartButton(productID, models, quantity, idToken, price) {
        console.log(productID, models, quantity, idToken, price);
        // 使用 Fetch API 向後端發送 POST 請求
        fetch(`api/shoppingCart/addToCart`, {
            method: 'POST',
            headers: {'Content-Type': 'application/json;charset=utf-8'},
            body: JSON.stringify({"productID": productID,"models": models,"quantity": quantity,"userID": idToken, "price": price})
        }).then(res => res.json())
            .then(data => console.log(data))
            .catch(error => console.error('Error:', error));
    }
});
