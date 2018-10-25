package com.example.demo;

import com.example.demo.LambdaDemo.BufferedReaderProcessor;
import com.example.demo.LambdaDemo.Role;
import com.example.demo.LambdaDemo.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;

/**
 * @Auther: TX
 * @Date: 2018/10/18 0018 11:39
 * @Description:
 */
public class TestJdk8 {

    public static void  main(String [] args) throws IOException {

        optionalTest();


    }

    private static void optionalTest() {
        User user = new User();

        System.out.println(user.getRole());

        //创建一个空的Optional对象
        Optional<Role> roleOpl = Optional.empty();

        Role role = new Role();

        //依据一个非空的值创建Optional,如果role == null ,throw NullPointException.
        Optional<Role> roleOpl1 = Optional.of(role);

        //创建一个可以为null值的Optional对象
        Optional<Role> roleOptional = Optional.ofNullable(role);
    }

    private static void streamTest() {
        List<User> list = new LinkedList<>();

        for (int i = 0 ; i<10 ; i ++){
            User user = new User();

            user.setUserName(i+"YourName");
            user.setAge(i+11);

            list.add(user);
        }

        list.stream().filter(user -> user.getAge() < 15).
                sorted(Comparator.comparing(User::getAge).reversed()).
                map(User::getUserName).
                forEach( System.out:: println);
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
