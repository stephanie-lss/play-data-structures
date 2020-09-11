package com.math.medium.solution535;

/**
 * @author LiSheng
 * @date 2020/4/16 11:03
 */
public class Codec {

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        return longUrl + "lisheng";
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortUrl.substring(0, shortUrl.length() - 7);
    }
}
