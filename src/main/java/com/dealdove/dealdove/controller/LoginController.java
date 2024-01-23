package com.dealdove.dealdove.controller;

import com.dealdove.dealdove.model.IdToken;
import com.dealdove.dealdove.model.MyRequest;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RestController
public class LoginController {




//    帳號註冊驗證
    @PostMapping("/verify")
    public int emailVerify(@RequestBody MyRequest user){
        String email = user.getEmail();
        String emailPattern = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b";
        Pattern emailRegex = Pattern.compile(emailPattern);
        Matcher emailMatcher = emailRegex.matcher(email);

        String password = user.getPassword();
        String passwordPattern ="^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        Pattern passwordRegex = Pattern.compile(passwordPattern);
        Matcher passwordMatcher = passwordRegex.matcher(password);

        if(!emailMatcher.matches()){
            return 10;
        }
        if(!passwordMatcher.matches()){
            return 20;
        }
        return 1;
    }




    @GetMapping("captcha")
    public static String generateCaptcha() {
        int width = 100;
        int height = 10;
        StringBuilder captchaCode = new StringBuilder();

        // 修改：使用 try-with-resources 创建 ByteArrayOutputStream
        try (ByteArrayOutputStream base64OutputStream = new ByteArrayOutputStream()) {

            Random random = new SecureRandom();

            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = image.createGraphics();

            // 设置背景色
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);

            // 添加干扰线条
//            for (int i = 0; i < 10; i++) {
//                graphics.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
//                int x1 = random.nextInt(width);
//                int y1 = random.nextInt(height);
//                int x2 = random.nextInt(width);
//                int y2 = random.nextInt(height);
//                graphics.drawLine(x1, y1, x2, y2);
//            }

            // 添加干扰点
            for (int i = 0; i < 50; i++) {
                graphics.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                int x = random.nextInt(width);
                int y = random.nextInt(height);
                graphics.drawOval(x, y, 1, 1);
            }

            // 设置字体
            graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 10));

            // 生成验证码字符
            for (int i = 0; i < 4; i++) {
                int temp = random.nextInt(26) + 97;
                char c = (char) temp;
                captchaCode.append(c);
                graphics.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                graphics.drawString(String.valueOf(c), i * (width / 4) + 10, height - (height / 3));
            }
                System.out.println(captchaCode);

            graphics.dispose();

            // 将图像写入 base64OutputStream
            ImageIO.write(image, "png", base64OutputStream);

            // 将图像的字节数组转换为 Base64 字符串
            String base64String = Base64.getEncoder().encodeToString(base64OutputStream.toByteArray());

            // 返回生成的 Base64 字符串
            return "{\"base64String\":\"" + base64String + "\",\"captchCode\":\"" + captchaCode + "\"}";

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }






}
