package com.demo.demo;

import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void contextLoads() {

		ValueOperations value = redisTemplate.opsForValue();
		HashOperations hashOperations = redisTemplate.opsForHash();
		ListOperations listOperations = redisTemplate.opsForList();
		SetOperations setOperations = redisTemplate.opsForSet();
		ZSetOperations zSetOperations = redisTemplate.opsForZSet();

		/*value.set("sKey","testString");
		System.out.println(value.get("sKey"));*/
		/*List<String> stringList = new ArrayList<String>();

		stringList.add("1");
		stringList.add("2");
		stringList.add("3");
		stringList.add("4");

		listOperations.leftPush("list",stringList);*/

		System.out.println(		value.setIfAbsent("sKey","setNX"));
		System.out.println(		value.setIfAbsent("sNX","setNX"));

		Map<String,Object> map = new HashedMap();

		map.put("name","test");
		map.put("age",132);

		hashOperations.putAll("map",map);

	}

}
