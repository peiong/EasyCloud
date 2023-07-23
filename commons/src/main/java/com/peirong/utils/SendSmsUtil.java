package com.peirong.utils;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Random;
import java.util.TreeMap;

@Component
@PropertySource(value = {"classpath:config/sms-config.properties"})
public class SendSmsUtil {
    private final static String CHARSET = "UTF-8";

    @Value("${SECRET_ID}")
    private String SECRET_ID;
    @Value("${SECRET_KEY}")
    private String SECRET_KEY;

    public String sign(String s, String key, String method) throws Exception {
        Mac mac = Mac.getInstance(method);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(CHARSET), mac.getAlgorithm());
        mac.init(secretKeySpec);
        byte[] hash = mac.doFinal(s.getBytes(CHARSET));
        return DatatypeConverter.printBase64Binary(hash);
    }

    public String getStringToSign(TreeMap<String, Object> params) {
        StringBuilder s2s = new StringBuilder("GETsms.tencentcloudapi.com/?");
        // 签名时要求对参数进行字典排序，此处用TreeMap保证顺序
        for (String k : params.keySet()) {
            s2s.append(k).append("=").append(params.get(k).toString()).append("&");
        }
        return s2s.substring(0, s2s.length() - 1);
    }

    public String getUrl(TreeMap<String, Object> params) throws UnsupportedEncodingException {
        StringBuilder url = new StringBuilder("https://sms.tencentcloudapi.com/?");
        for (String k : params.keySet()) {
            url.append(k).append("=").append(URLEncoder.encode(params.get(k).toString(), CHARSET)).append("&");
        }
        return url.substring(0, url.length() - 1);
    }

    public String postURL(String phone, String code) throws Exception {
        TreeMap<String, Object> params = new TreeMap<String, Object>();
        params.put("Nonce", new Random().nextInt(10000));
        params.put("Timestamp", System.currentTimeMillis() / 1000);
        params.put("SecretId", SECRET_ID);
        params.put("Action", "SendSms");
        params.put("Version", "2021-01-11");
        params.put("Region", "ap-nanjing");
        params.put("SmsSdkAppId", "1400802027");
        params.put("TemplateId", "1749895");
        params.put("TemplateParamSet.0", code);
        params.put("SignName", "EasyDrive公众号");
        params.put("PhoneNumberSet.0", "+86" + phone);
        params.put("SessionContext", "test");
        params.put("Signature", sign(getStringToSign(params), SECRET_KEY, "HmacSHA1"));
        System.out.println("curl '" + getUrl(params) + "'");
        return getUrl(params);
    }
}
