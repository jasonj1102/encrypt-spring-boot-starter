package com.github.jasonj1102.aesspringbootstarter.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * @author jie
 * @version 1.0
 * success come from self-discipline
 * 2021/4/14 22:44
 * value注解不能 和new 一起使用，value注解调用在new构造方法之后
 */
@Component
public class AesUtils {



    @Value(value = "${myProperties.key}")
    public void setSecret(String key){
        KEY = key;
    }

    private static String KEY;

    private static final String AES_ALGORITHM = "AES/ECB/PKCS5Padding";

    /**
     * 获取 cipher
     * @param key 密钥
     * @param model 模型因子
     * @return Cipher
     * @throws Exception
     */
    private static Cipher getCipher(String key, int model) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(model, secretKeySpec);
        return cipher;
    }

    /**
     * 加密算法
     * @param data 明文
     * @return String
     * @throws Exception
     */
    public  String encrypt(String data) throws Exception {
        System.out.println("key1 = "+KEY);
        Cipher cipher = getCipher(KEY, Cipher.ENCRYPT_MODE);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }

    /**
     * 解密算法
     * @param data 密文
     * @return String
     * @throws Exception
     */
    public  String decrypt(String data) throws Exception {
        Cipher cipher = getCipher(KEY, Cipher.DECRYPT_MODE);
        return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
    }
}
