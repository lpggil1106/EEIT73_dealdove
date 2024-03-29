import "https://code.jquery.com/jquery-3.6.0.min.js";
import {auth, onAuthStateChanged} from './firebase.js';
import{showToast} from "./jquery.toast.js";

$(document).ready(()=>{
    fetch("/Coupon/showCoupon")
        .then(response => response.json())
        .then(data => {
            data.forEach((couponBase, index) => {
                console.log(couponBase)
                // const target =  parseInt(couponBase.discount)>=1 ? "specify" : "tar";
                let targetContainer = document.getElementById("specify");

                if (index % 2 === 0) {
                    // 每一行的第一張優惠券，新增 .coupon-row 類別
                    const couponRow = document.createElement("div");
                    couponRow.className = "coupon-row";
                    console.log(couponRow)
                    targetContainer.appendChild(couponRow);
                }

                // 創建 coupon-card 元素
                const couponCard = document.createElement("div");
                couponCard.className = "coupon-card";

                // 創建圖片元素
                const img = document.createElement("img");
                img.src = "./images/coupon2.png";
                img.style.maxInlineSize = "6vw";
                couponCard.appendChild(img);

                // 創建 product-details 元素
                const details = document.createElement("div");
                details.style.marginLeft = "1vw";
                details.className = "product-details"; // 使用 className 屬性

                // 創建 couponcode 元素
                const couponCode = document.createElement("h2");
                couponCode.innerText = couponBase.couponName;
                couponCode.id=`couponCode${index}`
                details.appendChild(couponCode);


                // 創建其他元素（可根據需要添加）
                const couponNumber = document.createElement("p");
                couponNumber.innerText = "折扣碼 " + couponBase.couponCode;
                details.appendChild(couponNumber);

                const productPricing = document.createElement("div");
                productPricing.className = "product-pricing";

                const conditions = document.createElement("p");
                conditions.innerText = "使用條件";
                productPricing.appendChild(conditions);

                const discountMethod = document.createElement("p");
                discountMethod.innerText = couponBase.couponDescription;
                discountMethod.style.color = "gray";
                discountMethod.style.fontSize = "1vw";
                productPricing.appendChild(discountMethod);

                // 格式化日期
                const expirationDate = new Date(couponBase.expirationDate);
                const formattedDate =`${expirationDate.getFullYear()}-${String(expirationDate.getMonth() + 1).padStart(2, '0')}-${String(expirationDate.getDate()).padStart(2, '0')}  ${String(expirationDate.getHours()).padStart(2, '0')}:${String(expirationDate.getMinutes()).padStart(2, '0')}`;
                const exdate = document.createElement("p");
                exdate.innerText = "有效期限至 " + formattedDate;
                exdate.style.marginTop = "1vw";
                exdate.style.fontSize = "1vw";
                productPricing.appendChild(exdate);

                details.appendChild(productPricing);
                couponCard.appendChild(details);

                let couponBaseID = couponBase.couponBaseID;
                // 創建領取按鈕
                const getCouponButton = document.createElement("button");
                getCouponButton.innerText = "領取";
                getCouponButton.id=`getCouponButton${index}`;
                getCouponButton.classList.add("get-coupon"); // 使用 classList.add 方法
                getCouponButton.style.marginLeft = "1vw";
                // console.log(getCouponButton)
                couponCard.appendChild(getCouponButton);
                //const currentRow = document.querySelector(`#${target}`).querySelector(".coupon-row:last-child");
                const currentRow = targetContainer.querySelector(".coupon-row:last-child");
                // console.log(couponCard)
                currentRow.appendChild(couponCard);

               $(`#getCouponButton${index}`).on('click',()=>{
                   console.log('test')
                   onAuthStateChanged(auth, (user => {
                           if (user) {
                               user.getIdToken()
                                   .then(idToken => {
                                       console.log(`couponCode${index}`);
                                       sendCouponToBack(idToken,couponBaseID)
                                   })
                                   .catch(err=>console.log(err))
                           }
                       })
                   );
               });
            });
        })
        .catch(error => console.log(error));


    function sendCouponToBack(idToken,couponBaseID){
        fetch('/getCoupon',{
            method:'POST',
            headers: {'Content-Type': 'application/json;charset=utf-8'},
            body:JSON.stringify({"idToken":idToken,"couponBaseID":couponBaseID})
        }).then(res=>res.json())
            .then(data=>{
                if (data===10){
                    showToast('領取成功')
                }else if(data===20){
                    showToast('領取過了')
                }
            })

    }


})