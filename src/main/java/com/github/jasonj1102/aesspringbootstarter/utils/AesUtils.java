package com.github.jasonj1102.aesspringbootstarter.utils;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * @author jie
 * @version 1.0
 * success come from self-discipline
 * @date 2021/4/14 22:44
 */
@Component
public class AesUtils {
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
     * @param key 密钥
     * @return String
     * @throws Exception
     */
    public static String encrypt(String data, String key) throws Exception {
        Cipher cipher = getCipher(key, Cipher.ENCRYPT_MODE);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }

    /**
     * 解密算法
     * @param data 密文
     * @param key 密钥
     * @return String
     * @throws Exception
     */
    public static String decrypt(String data, String key) throws Exception {
        Cipher cipher = getCipher(key, Cipher.DECRYPT_MODE);
        return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
    }
}
