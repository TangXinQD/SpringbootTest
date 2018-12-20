package com.demo.demo.LambdaDemo;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @Auther: TX
 * @Date: 2018/10/18 0018 14:22
 * @Description:
 */
@FunctionalInterface
public interface BufferedReaderProcessor {

    String processor(BufferedReader bufferedReader) throws IOException;

}
