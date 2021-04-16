package com.github.jasonj1102.aesspringbootstarter;

import com.github.jasonj1102.aesspringbootstarter.utils.AesUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class AesSpringBootStarterApplicationTests {

    @Value(value = "${myProperties.key}")
    private String key;

    @Autowired
    private AesUtils aesUtils;

    @Test
    void contextLoads() throws Exception {
        System.out.println(key);
//        AesUtils aesUtils = new AesUtils();
        String encode = aesUtils.encrypt("zzz");
        System.out.println(encode);
        System.out.println(aesUtils.decrypt(encode));
    }

}
