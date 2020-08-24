package com.demo.demo.hutool;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.MD5;


/**
 * @author TX
 * @version 1.0
 * @description HutoolMd5
 * @date 2020/8/21 4:49 下午
 */
public class HutoolMd5 {

    public static void main(String[] args) {
        MD5 md5 = SecureUtil.md5();
        String s = md5.digestHex("/place_cloud/data/create?data=[{\"ud_id\":\"156985\",\"title\":\"海淀区苏州街营业部\",\"location\":{\"lat\":39.983988,\"lng\":116.307709},\"x\":{\"price\":15.5}}]&key=5Q5BZ-5EVWJ-SN5F3-K6QBZ-*****&table_id=5d405395d230bf1d9416be10KIpUE64TiqLuF2vBJCLOvkFVy0we0Ypp");
        System.out.println(s);
    }
}
