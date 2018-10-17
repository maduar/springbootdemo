//package com.maduar.springbootdemo.utils;
//
//import com.sun.org.apache.xml.internal.security.utils.Base64;
//
//import javax.crypto.Cipher;
//import javax.crypto.KeyGenerator;
//import java.io.UnsupportedEncodingException;
//import java.security.Key;
//import java.security.NoSuchAlgorithmException;
//import java.security.SecureRandom;
//
///*
// *
// * @author maduar
// * @date 17/10/2018 1:17 PM
// * @email maduar@163.com
// *
// * */
//public class DESUtils {
//
//    private DESUtils() {
//    }
//
//    private static Key key;
//    private static String KEY_STR = "maduar@163.com";
//
//    public static final String UTF_8 = "UTF-8";
//    public static final String ENCODE_DES = "DES";
//    public static final String DES = "DES";
//
//    static {
//        try{
//            //  key factory
//            KeyGenerator keyGenerator = KeyGenerator.getInstance(DES);
//
//            // init sercure random
//            keyGenerator.init(new SecureRandom(KEY_STR.getBytes(UTF_8)));
//
//            // create key
//            key = keyGenerator.generateKey();
//
//            keyGenerator = null;
//
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static String encode(String sourceCode) {
//
//        String result = null;
//
//        if (sourceCode == null || "".equals(sourceCode)) {
//            return result;
//        }
//
//        try{
//            // get byte array
//            byte[] sourceCodeByteArray = sourceCode.getBytes(UTF_8);
//
//
//            Cipher cipher = Cipher.getInstance(ENCODE_DES);
//            // set encode mode
//            cipher.init(Cipher.ENCRYPT_MODE, key);
//
//            // encode
//            byte[] encodeByteArray = cipher.doFinal(sourceCodeByteArray);
//
//            // byte to String
//            result = Base64.encode(encodeByteArray);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return result;
//    }
//
//
//    public static String decode(String encrypted) {
//        String result = null;
//
//        if (encrypted == null || "".equals(encrypted)) {
//            return result;
//        }
//
//        try {
//            // String to bytes
//            byte[] encryptedBytes = Base64.decode(encrypted);
//
//            Cipher cipher = Cipher.getInstance(DES);
//            // set encode mode
//            cipher.init(Cipher.DECRYPT_MODE, key);
//
//            // decode
//            byte[] encodeBytes = cipher.doFinal(encryptedBytes);
//
//            result = new String(encodeBytes, UTF_8);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return result;
//    }
//
//}
