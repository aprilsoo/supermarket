package com.example.supermarket.utils;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class Base64Util {
    public static final String converToBase64(MultipartFile file) {
        byte[] bytes = new byte[0];
        try {
            bytes = file.getBytes();
            String string = Base64.encodeBase64String(bytes);
            string.replaceAll("[\\s*\t\n\r]", "");
            string = "data:image/png;base64," + string;
            return string;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
