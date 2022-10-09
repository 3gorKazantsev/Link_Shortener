package org.egorkazantsev.linkshortener.util;

public class Util {

    private static final char[] base62Alphabet =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

    // mapping number (base 10) to string (base 62)
    public static String mapBase10ToBase62(long number) {
        StringBuilder result = new StringBuilder();

        long remainder;

        while (number > 0) {
            remainder = number % 62;
            result.append(base62Alphabet[(int) remainder - 1]);
            number /= 62;
        }

        return result.toString();
    }
}
