package com.example.demo;

import com.example.demo.LambdaDemo.BufferedReaderProcessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * @Auther: TX
 * @Date: 2018/10/18 0018 11:39
 * @Description:
 */
public class TestJdk8 {

    public static void  main(String [] args) throws IOException {
        lambdaTest2();
    }


    //方法的引用
    private static void lambdaTest2() throws IOException {

        List<String > list = Arrays.asList("a","bb","Aa","Bb");

        list.sort(Comparator.comparing(String::length).reversed().thenComparing(String::hashCode));
//        list.sort((String a,String b)->a.compareToIgnoreCase(b));
//        list.sort(String :: compareToIgnoreCase);
        System.out.println(list);
    }

    //lambda表达式
    private static void lambdaTest1() throws IOException {
        String line = processFile((BufferedReader br) -> br.readLine());

        List<String > list = Arrays.asList("a","b","A","B");

        List<Integer> results = filter(list, (String s) -> s.length());
        List<Integer> results1 = filter(list, String::length);

        list.sort((String a,String b)->a.compareToIgnoreCase(b));
        list.sort(String :: compareToIgnoreCase);
        System.out.println(list);
        System.out.println(results);
    }

    public static String processFile(BufferedReaderProcessor bufferedReaderProcessor) throws IOException{


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("dd.txt"))){

            return bufferedReaderProcessor.processor(bufferedReader);
        }
    }

    /*public static <T> List<T> filter(List<T> list ,Predicate<T> predicate) throws IOException{
        List<T> results = new ArrayList<>();
        for (T t : list) {
            if(predicate.test(t)){
                results.add(t);
            }
        }
        return  results;
    }*/

    public static <T,R> List<R> filter(List<T> list ,Function<T,R> function) throws IOException{
        List<R> results = new ArrayList<>();
        for (T t : list) {
            results.add(function.apply(t));
        }
        return  results;
    }


}
