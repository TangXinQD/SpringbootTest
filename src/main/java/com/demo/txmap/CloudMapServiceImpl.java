package com.demo.txmap;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.demo.txmap.model.TencentMapDTO;
import com.demo.txmap.model.TencentMapFinalDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author TX
 * @version 1.0
 * @description CloudMapServiceImpl
 * @date 2020/8/24 11:24 上午
 */
@Slf4j
@Service
public class CloudMapServiceImpl implements CloudMapService {

    private String key = "PW4BZ-FM7C3-5523I-YQSNI-53RX5-ECBMY";

    private String sign = "w3ONkgv7xr2rxjAHclGzM7N00YfWfCjJ";

    private String url = "https://apis.map.qq.com/place_cloud/data/create";

    private String geoCoderUrl = "https://apis.map.qq.com/ws/geocoder/v1";

    @Override
    public Object saveData(String table, List<TencentMapDTO> list) throws JsonProcessingException {
        TencentMapFinalDTO dto = new TencentMapFinalDTO("PW4BZ-FM7C3-5523I-YQSNI-53RX5-ECBMY",table, list);

        StringBuilder signStr = new StringBuilder("/place_cloud/data/create");
        signStr.append("?").append(sort(dto)).append("w3ONkgv7xr2rxjAHclGzM7N00YfWfCjJ");
        System.out.println(signStr);
        log.info("signStr->{}",signStr);
        String sig = DigestUtils.md5DigestAsHex(signStr.toString().getBytes());
        log.info("sig->{}",sig);

        String s1 = JSONObject.toJSONString(dto);

        log.info("request->{}",s1);
        StringBuilder urlStr = new StringBuilder(url);
        urlStr.append("?sig=").append(sig);
        log.info("url->{}",urlStr);
        String response = HttpUtil.post(urlStr.toString(), s1);

        log.info("response->{}",response);
        return response;
    }

    @Override
    public Object saveDataTest(String table, List<TencentMapDTO> list) throws JsonProcessingException {
        TencentMapFinalDTO dto = new TencentMapFinalDTO("KQVBZ-CP7HX-YMK4G-73ELK-GU7JV-SJFYU",table, list);

        StringBuilder signStr = new StringBuilder("/place_cloud/data/create");
        signStr.append("?").append(sort(dto)).append("aUkOIXFwAXtJEoyPAxd9aGfEzOs5r77");
        System.out.println(signStr);
        log.info("signStr->{}",signStr);
        String sig = DigestUtils.md5DigestAsHex(signStr.toString().getBytes());
        log.info("sig->{}",sig);

        String s1 = JSONObject.toJSONString(dto);

        log.info("request->{}",s1);
        StringBuilder urlStr = new StringBuilder(url);
        urlStr.append("?sig=").append(sig);
        log.info("url->{}",urlStr);
        String response = HttpUtil.post(urlStr.toString(), s1);

        log.info("response->{}",response);
        return response;
    }

    @Override
    public Object geoCoder(BigDecimal lat, BigDecimal lng) throws JsonProcessingException {
        StringBuilder signStr = new StringBuilder("/ws/geocoder/v1?");
        signStr.append("key=").append(key).append("&location=").append(lat.toString()).append(",").append(lng.toString()).append(sign);
        String sig = DigestUtils.md5DigestAsHex(signStr.toString().getBytes());

        StringBuilder url = new StringBuilder(geoCoderUrl);
        url.append("?key=").append(key).append("&location=").append(lat.toString()).append(",").append(lng.toString()).append("&sig=").append(sig);
        String response = HttpUtil.get(url.toString());
        log.info("response->{}",response);
        return response;
    }

    public String sort(Object o){
        //noticedata按照属性排序
        String s = JSONObject.toJSONString(o, SerializerFeature.MapSortField);
        JSONObject jsonObject = JSONObject.parseObject(s, Feature.OrderedField);
        Iterator<Map.Entry<String, Object>> iterator = jsonObject.entrySet().iterator();
        StringBuffer ser= new StringBuffer();
        //拼接参数
        while (iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            ser.append(next.toString()).append("&");
        }
        return ser.substring(0,ser.length()-1);
    }
}
