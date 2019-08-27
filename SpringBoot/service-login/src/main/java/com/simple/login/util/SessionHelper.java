package com.simple.login.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.simple.login.constant.SessionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author:伍梓涛
 * @version:1.0.0
 * @Modified By:SimpleWu
 * @CopyRright (c)2019-:YUM架构平台
 */
@Component
public class SessionHelper {


    public SessionHelper() {
        sessionHelper = this;
    }

    public static SessionHelper buidler() {
        return sessionHelper;
    }

    private static SessionHelper sessionHelper;

    @Autowired
    private RedisTemplate redisTemplate;


    public Object get(String token) {
        BoundValueOperations boundValueOperations = redisTemplate.boundValueOps(SessionConstant.TOKEN_PRE + token);
        return boundValueOperations.get();
    }


    public String login(Object object) {
        String objectStr = JSON.toJSONString(object);
        String token = UUID.randomUUID().toString();
        while (true) {
            if (!hasToken(token)) {
                break;
            }
            token = UUID.randomUUID().toString();
        }
        BoundValueOperations boundValueOperations = redisTemplate.boundValueOps(SessionConstant.TOKEN_PRE + token);
        boundValueOperations.set(objectStr, SessionConstant.TOKEN_OUT_TIME, TimeUnit.SECONDS);
        return token;
    }


    public boolean hasToken(String token) {
        return redisTemplate.hasKey(SessionConstant.TOKEN_PRE + token);
    }

}
