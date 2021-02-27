package me.mical.becaptcha.utils;

import java.util.Random;

public class CaptchaUtil {

    public static String generate(final int index) {
        final StringBuilder captcha = new StringBuilder();
        final String chars = "0123456789abcdefghijklmnopqrstuvwxyz";
        final int length = chars.length();
        for (int i = 0; i < index; i++) {
            final int nextInt = new Random().nextInt(length);
            captcha.append(chars.charAt(nextInt));
        }
        return captcha.toString();
    }
}
