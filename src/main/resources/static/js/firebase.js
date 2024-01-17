import {initializeApp} from "https://www.gstatic.com/firebasejs/10.7.1/firebase-app.js";
import {getAnalytics} from "https://www.gstatic.com/firebasejs/10.7.1/firebase-analytics.js";
import {getAuth} from "https://www.gstatic.com/firebasejs/10.7.1/firebase-auth.js";
// Firebase 配置
const firebaseConfig = {
    apiKey: "AIzaSyA0xrDB28Kk2gvgj-Ho0wvTNemqqkqytuo",
    authDomain: "dealdove-36d8c.firebaseapp.com",
    projectId: "dealdove-36d8c",
    storageBucket: "dealdove-36d8c.appspot.com",
    messagingSenderId: "997598982157",
    appId: "1:997598982157:web:8728a77f135fec514ba544",
    measurementId: "G-7ZRGD1VDM6"
};


// 初始化 Firebase
const firebase = initializeApp(firebaseConfig);
const analytics = getAnalytics(firebase);
const auth = getAuth(firebase);

export {auth};