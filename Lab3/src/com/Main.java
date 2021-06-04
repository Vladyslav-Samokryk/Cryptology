package com;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {
        Charset cs = Charset.forName("UTF-8");
        String value = "Hello, it's me. This is a text for cryptology";
        byte[] data = value.getBytes(cs);
        byte[] hash = SHA256.encode(data);

        StringBuilder hex = new StringBuilder(hash.length * 2);
        int len = hash.length;
        for (int i = 0 ; i < len ; i++) {
            hex.append(String.format("%02X", hash[i]));
        }
        System.out.println( hex.toString().toLowerCase());
    }
}
