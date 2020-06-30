package com.demo.demo.bloom;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.Charset;

/**
 * @description: Bloom
 * @date: 2020/6/29 4:18 下午
 * @author: TX
 * @version: 1.0
 */
public class Bloom {





    public static void main(String[] args) {
        BloomFilter<String> filter =
                BloomFilter.create(Funnels.stringFunnel(Charset.forName("UTF-8")), 1000,0.01);

        filter.put("ddd");
        filter.put("eee");
        filter.put("a");
        filter.put("b");


        System.out.println(filter.mightContain("dd"));
        System.out.println(filter.mightContain("ddd"));

    }
}
