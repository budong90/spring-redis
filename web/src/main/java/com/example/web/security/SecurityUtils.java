package com.example.web.security;

import sun.security.rsa.RSAPrivateCrtKeyImpl;
import sun.security.rsa.RSAPublicKeyImpl;

import java.io.FileInputStream;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author sunli
 * @create 2018-01-24 10:00
 */

public class SecurityUtils {
    /**
     * 解密
     *
     * @param cipherText 密文
     * @return 返回解密后的字符串
     * @throws Exception
     */
    public static String decrypt(String cipherText) throws Exception {
        // 从文件中得到私钥
        FileInputStream inPrivate = new FileInputStream(
                SecurityUtils.class.getClassLoader().getResource("").getPath() + "/pkcs8_private_key.pem");
        PrivateKey privateKey = RSAUtils.loadPrivateKey(inPrivate);
        byte[] decryptByte = RSAUtils.decryptData(Base64Utils.decode(cipherText), privateKey);
        String decryptStr = new String(decryptByte, "utf-8");
        return decryptStr;
    }

    /**
     * 加密
     *
     * @param plainTest 明文
     * @return 返回加密后的密文
     * @throws Exception
     */
    public static String encrypt(String plainTest) throws Exception {
        FileInputStream inPublic = new FileInputStream(
                SecurityUtils.class.getClassLoader().getResource("").getPath() + "/rsa_public_key.pem");
        PublicKey publicKey = RSAUtils.loadPublicKey(inPublic);
        // 加密
        byte[] encryptByte = RSAUtils.encryptData(plainTest.getBytes(), publicKey);
        String afterencrypt = Base64Utils.encode(encryptByte);
        return afterencrypt;
    }

    public static void main(String[] args) throws Exception {
        String text = "天才就是99%的汗水+1%的灵感";
//        String encrypt = SecurityUtils.encrypt(text);
//        System.out.println(encrypt);
//        String decrypt = SecurityUtils.decrypt(text);
//        System.out.println(decrypt);
        KeyPair keyPair = RSAUtils.generateRSAKeyPair();
        System.out.println(keyPair);
        RSAPublicKeyImpl publicKey = (RSAPublicKeyImpl) keyPair.getPublic();
        RSAPrivateCrtKeyImpl privateKey = (RSAPrivateCrtKeyImpl) keyPair.getPrivate();
        System.out.println(publicKey.toString());
        System.out.println(privateKey.toString());

        byte[] encryptByte = RSAUtils.encryptData(text.getBytes(), publicKey);
        String afterencrypt = Base64Utils.encode(encryptByte);
        System.out.println("加密：" + afterencrypt);
        byte[] decryptByte = RSAUtils.decryptData(Base64Utils.decode(afterencrypt), privateKey);
        String decryptStr = new String(decryptByte, "utf-8");
        System.out.println("解密：" + decryptStr);
    }
}
