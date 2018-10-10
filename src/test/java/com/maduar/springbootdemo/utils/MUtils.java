package com.maduar.springbootdemo.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/*
 *
 * @author maduar
 * @date 02/07/2018 11:22 AM
 * @email maduar@163.com
 *
 * */
public class MUtils {

    public static String createBase64ByObject(Object object) {
        if (object == null) {
            return null;
        }

        String key = JSON.toJSONString(object);
        String str = Base64.encodeBase64String(key.getBytes());

        return str;
    }

    public static String createHeaderString(Object object) {
        return createBase64ByObject(object);
    }

    public static String createPlayloadString(Object object) {
        String result = createBase64ByObject(object);

        if (result == null) {
            return null;
        }

        result = result.replace("=", "");
        return result;
    }

    public static String HMACSHA256(String message, String secret) {
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] bytes = sha256_HMAC.doFinal(message.getBytes());
            String hash = byteArrayToHexString(bytes);
            return hash;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b != null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }

        return hs.toString().toLowerCase();
    }

    public static void getRequest() throws Exception {
        CloseableHttpClient httpclient = null;
        CloseableHttpResponse response = null;
        try {
            httpclient = HttpClients.createDefault();
            // 创建httpget.
            HttpGet httpget = new HttpGet("http://www.baidu.com/");
            // 执行get请求.
            response = httpclient.execute(httpget);
            // 获取响应实体
            HttpEntity entity = response.getEntity();

            // 打印响应状态
            System.out.println(response.getStatusLine().getStatusCode());
            if (entity != null) {
                // 打印响应内容
                System.out.println("Response content: " + EntityUtils.toString(entity));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            httpclient.close();
            response.close();
        }
    }

    public static void main(String[] args) throws Exception {
        String encodedString = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9";
        String signature = HMACSHA256(encodedString, "secret");
        System.out.println("signature: " + signature);

//        MUtils.getRequest();
//        Check.check()
    }


}
