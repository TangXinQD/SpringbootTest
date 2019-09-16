package com.demo.demo.kyTest;


import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.TreeMap;

public class BaseTest {
    public String signKey = "aTrtmsyhxlA8620810671";
    public RestTemplate restTemplate = null;
    @Before
    public void before(){
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName("utf-8")));
    }

    public ReceiveNotifyWaitHandle init() {
        ReceiveNotifyWaitHandle waitHandle = new ReceiveNotifyWaitHandle();
        waitHandle.setDockingFlag("JT");
        waitHandle.setFlowNo(System.currentTimeMillis() + "");
        return waitHandle;
    }

    public MultiValueMap<String, String> bulidParams(ReceiveNotifyWaitHandle bean){
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("timeStamp", bean.getTimeStamp());
        params.add("dockingFlag", bean.getDockingFlag());
        params.add("content", bean.getContent());
        params.add("sign",bean.getSign());
        return params;
    }


    /**
     * md5签名
     * 按照key1=value1&key2=value2.....方式进行，代签名字符串根据key首字母进行升序排序
     * @param map
     * @param key
     * @return
     */
    public static String signForMd5(Map<String,String> map, String key){
        Map<String, String> treeMap = new TreeMap<>(map);
        StringBuilder builder = new StringBuilder();
        for(String nkey : treeMap.keySet()){
            if(StringUtils.isBlank(map.get(nkey))){
                continue;
            }
            if("sign".equals(nkey)){
                continue;
            }
            builder.append(nkey)
                    .append("=")
                    .append(map.get(nkey))
                    .append("&");
        }
        String prepareSignMsg = builder.toString().substring(0,builder.toString().lastIndexOf("&"))+key;
        System.out.println("生成待签名字符串：" + prepareSignMsg);
        return getMd5Sign(prepareSignMsg, "UTF-8");
    }

    public static String getMd5Sign(String prepareString,String charSet){
        try{
            return DigestUtils.md5Hex(prepareString.getBytes(charSet));
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
        String targetAgentNo = "6aaaaaaa";
        String agentLine = "601391919-601392918-601392911";
        agentLine = targetAgentNo + agentLine.substring(agentLine.indexOf("-"));
        System.out.println(agentLine);
    }
}
