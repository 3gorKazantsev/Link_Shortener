package org.egorkazantsev.linkshortener.util;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ShortLinkUtil {

    private final char[] base62Alphabet =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

    @Value("${application.url}")
    private String url;

    // mapping number (base 10) to string (base 62)
    public String mapBase10ToBase62(long number) {
        StringBuilder result = new StringBuilder();

        long remainder;

        while (number > 0) {
            remainder = number % 62;
            result.append(base62Alphabet[(int) remainder - 1]);
            number /= 62;
        }

        return result.toString();
    }

    public String createShortLink(String shortName) {
        return url + shortName;
    }
}
