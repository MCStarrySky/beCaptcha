package me.mical.becaptcha.utils;

import java.util.Random;

public class CaptchaUtil {

    public static String generate(int index) {
        StringBuilder captcha = new StringBuilder();
        String chars = "0123456789abcdefghijklmnopqrstuvwxyz";
        int length = chars.length();
        for (int i = 0; i < index; i++) {
            int nextInt = new Random().nextInt(length);
            captcha.append(chars.charAt(nextInt));
        }
        return captcha.toString();
    }
}
