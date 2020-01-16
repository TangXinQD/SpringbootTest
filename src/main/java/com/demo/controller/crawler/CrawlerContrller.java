package com.demo.controller.crawler;


import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@RequestMapping("/creditCardData")
@RestController
@Slf4j
public class CrawlerContrller {

    @Autowired
    private HttpServletRequest request;


    @GetMapping("/getImg")
    public Object getImg(String bankCode) throws IOException {
        String sessionId = request.getSession().getId();

        byte[] img = getImg(bankCode, sessionId);

        return img;
    }

    private static byte[] getImg(String bankCode, String sessionId) throws IOException {
        Map<String, String> headers = new HashMap<>(8);
        headers.put("Accept", "image/webp,image/apng,image/*,*/*;q=0.8");
        headers.put("Accept-Encoding", "gzip, deflate, br");
        headers.put("Accept-Language", "zh-CN,zh;q=0.9");
        headers.put("Host", "creditcard.ecitic.com");
        headers.put("Referer", "https://creditcard.ecitic.com/citiccard/net-ebank/ebank-approval/index.html");

        Connection.Response response = Jsoup.connect("https://creditcard.ecitic.com/citiccard/ebank-userinfo-web-cloud/vcard/getrandcode?t=" + System.currentTimeMillis())
                .ignoreContentType(true)
                .ignoreHttpErrors(true)
                .validateTLSCertificates(false)
                .method(Connection.Method.GET)
                .headers(headers)
                .userAgent("Mozilla/5.0 (Linux; Android 6.0; 1503-M02 Build/MRA58K) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0Chrome/37.0.0.0 Mobile MQQBrowser/6.2 TBS/036558 Safari/537.36 MicroMessenger/6.3.25.861 NetType/WIFI Language/zh_CN")
                .timeout(6000)
                .execute();

        return response.bodyAsBytes();
    }

    private static File saveImg(byte[] img, String filePath, String fileName) throws Exception {
        BufferedOutputStream bufferedOutputStream = null;
        FileOutputStream fileOutputStream = null;
        File file = null;

        file = new File(fileName);
        fileOutputStream = new FileOutputStream(file);
        bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(img);
        log.info("验证码已经下载到:{}", file.getPath());
        return file;
    }

    public static void main(String[] args) throws Exception {
        byte[] img = getImg("", "1231231231");
        File file = saveImg(img, "/root", "img.png");
        System.out.println(file);
    }
}
