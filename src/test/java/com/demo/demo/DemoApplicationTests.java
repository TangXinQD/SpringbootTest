package com.demo.demo;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.demo.domain.XYTS;
import com.demo.mapper.BannerMapper;
import com.demo.service.TransactionTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

//	@Autowired
//	private RedisTemplate redisTemplate;

	@Autowired
	private BannerMapper bannerMapper;

	@Test
	public void contextLoads() {

		/*ValueOperations value = redisTemplate.opsForValue();
		HashOperations hashOperations = redisTemplate.opsForHash();
		ListOperations listOperations = redisTemplate.opsForList();
		SetOperations setOperations = redisTemplate.opsForSet();
		ZSetOperations zSetOperations = redisTemplate.opsForZSet();

		*//*value.set("sKey","testString");
		System.out.println(value.get("sKey"));*//*
		*//*List<String> stringList = new ArrayList<String>();

		stringList.add("1");
		stringList.add("2");
		stringList.add("3");
		stringList.add("4");

		listOperations.leftPush("list",stringList);*//*

		System.out.println(		value.setIfAbsent("sKey","setNX"));
		System.out.println(		value.setIfAbsent("sNX","setNX"));

		Map<String,Object> map = new HashedMap();

		map.put("name","test");
		map.put("age",132);

		hashOperations.putAll("map",map);*/
		List<XYTS> customer = bannerMapper.findCustomer();
		customer.stream().forEach( xyts -> {
			StringBuffer sb = new StringBuffer("INSERT INTO `agent_product`.`notify_out_agent_error` \n" +
					"(`optimistic`, `notify_optimistic`, `status`, `create_time`, `update_time`, `notify_type`, `sign`, `time_stamp`, \n" +
					"`accept_key`, `flow_no`, `docking_flag`, `content`, `handle_count`, `cur_retry_time`, `next_retry_time`, `method_name`, `remark`, `business_no`) \n" +
					"VALUES ( '0', '1', 'SUCCESS', '2020-01-06 17:03:12', '2020-01-06 17:04:00', 'mPosBindPushToXYTS', '2677cb327defb230aa65e94a8cce0b08', '1578301391889', \n" +
					"'qJMgZbzNpCRg4JFjlT9MKQ12', '20010617031188227184', 'YDX',\n" +
					"'");
			System.out.println(sb.append(JSONObject.toJSONString(xyts, SerializerFeature.WriteMapNullValue)).append("',\n" +
					" '2', '2020-01-06 17:03:12', NULL, NULL, '推送成功', '").append(xyts.getCustomerNo()).append("');"));
		});

	}

	@Resource
	private TransactionTestService transactionTestService;

	@Test
	public void testTransactional() throws Exception {
		transactionTestService.A();
	}


}
