package com.demo.demo;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class TestBinary {

    public static void main(String[] args) throws UnsupportedEncodingException {
        int t = 0 | (1 << 4-1);
        t = t | (1 << 3-1);

        int i = t & (1 << 4-1);
        System.out.println(t);
        System.out.println(Integer.toBinaryString(t));
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));

    }
}
