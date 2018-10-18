package com.example.demo;

import com.example.demo.LambdaDemo.BufferedReaderProcessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @Auther: TX
 * @Date: 2018/10/18 0018 11:39
 * @Description:
 */
public class TestJdk8 {

    public static void  main(String [] args) throws IOException {
//        String line = processFile((BufferedReader br) -> br.readLine());

        List<String > list = new ArrayList<>();
        list.add("abc");
        list.add("bdfa");
        list.add("cfadsfa");
        list.add("dfdafa");
        List<Integer> results = filter(list, (String s) -> s.length());

        System.out.println(results);
    }

    public static String processFile(BufferedReaderProcessor bufferedReaderProcessor) throws IOException{


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("dd.txt"))){

            return bufferedReaderProcessor.processor(bufferedReader);
        }
    }

    public static <T> List<T> filter(List<T> list ,Predicate<T> predicate) throws IOException{
        List<T> results = new ArrayList<>();
        for (T t : list) {
            if(predicate.test(t)){
                results.add(t);
            }
        }
        return  results;
    }

    public static <T,R> List<R> filter(List<T> list ,Function<T,R> function) throws IOException{
        List<R> results = new ArrayList<>();
        for (T t : list) {
            results.add(function.apply(t));
        }
        return  results;
    }


}
