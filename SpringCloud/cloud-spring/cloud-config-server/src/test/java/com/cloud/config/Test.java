package com.cloud.config;

import org.jasypt.encryption.StringEncryptor;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class Test {


    @Autowired
    StringEncryptor encryptor;

    @org.junit.Test
    public void getPass() {
        String pass = "qq508550571";

        System.out.println("加密密码: "+encryptor.encrypt(pass));

    }
}
