package com.dealdove.dealdove.model.dto;

import java.net.URLDecoder;

public class DecodeURLExample {

    public static void main(String[] args) {
        String encodedStoreName = "%E9%BE%8D%E6%98%8C%E9%96%80%E5%B8%82";

        try {
            // 解碼
            String decodedStoreName = URLDecoder.decode(encodedStoreName, "UTF-8");

            // 打印解碼後的值
            System.out.println("Decoded Store Name: " + decodedStoreName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
