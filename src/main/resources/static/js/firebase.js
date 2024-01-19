 // Import the functions you need from the SDKs you need
    import { initializeApp } from "https://www.gstatic.com/firebasejs/10.7.2/firebase-app.js";
    import { getAnalytics } from "https://www.gstatic.com/firebasejs/10.7.2/firebase-analytics.js";
    import {getAuth,GoogleAuthProvider,signInWithPopup,onAuthStateChanged,signOut,createUserWithEmailAndPassword,sendEmailVerification,signInWithEmailAndPassword} from  "https://www.gstatic.com/firebasejs/10.7.2/firebase-auth.js";
    // TODO: Add SDKs for Firebase products that you want to use
    // https://firebase.google.com/docs/web/setup#available-libraries

    // Your web app's Firebase configuration
    // For Firebase JS SDK v7.20.0 and later, measurementId is optional
    const firebaseConfig = {
    apiKey: "AIzaSyA0xrDB28Kk2gvgj-Ho0wvTNemqqkqytuo",
    authDomain: "dealdove-36d8c.firebaseapp.com",
    databaseURL: "https://dealdove-36d8c-default-rtdb.asia-southeast1.firebasedatabase.app",
    projectId: "dealdove-36d8c",
    storageBucket: "dealdove-36d8c.appspot.com",
    messagingSenderId: "997598982157",
    appId: "1:997598982157:web:8728a77f135fec514ba544",
    measurementId: "G-7ZRGD1VDM6"
};

    // Initialize Firebase
    const app = initializeApp(firebaseConfig);
    const analytics = getAnalytics(app);
    const auth = getAuth(app);
    const provider = new GoogleAuthProvider();
    export {auth,provider,signInWithPopup,onAuthStateChanged,signOut,createUserWithEmailAndPassword,sendEmailVerification,signInWithEmailAndPassword}
