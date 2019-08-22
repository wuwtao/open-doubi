package com.spring.boot.redis.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author:伍梓涛
 * @version:1.0.0
 * @Modified By:SimpleWu
 * @CopyRright (c)2019-:YUM架构平台
 */
@Component
public class RedisUtils {

    private Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 设置key过期时间
     *
     * @param key
     * @param outime
     * @return
     */
    public boolean expire(Object key, long outime, TimeUnit timeUnit) {
        try {
            return redisTemplate.expire(key, outime, timeUnit);
        } catch (Exception e) {
            logger.error("redis set key:{} , outime{} error", key, outime);
            return false;
        }
    }


    /**
     * 获取key过期时间
     *
     * @param key
     * @param timeUnit
     * @return
     */
    public Long getExpire(Object key, TimeUnit timeUnit) {
        try {
            return redisTemplate.getExpire(key, timeUnit);
        } catch (Exception e) {
            logger.error("redis get key:{} , TimeUnit{} error", key, timeUnit);
            return -1l;
        }
    }

    /**
     * key是否存在
     *
     * @param key
     * @return
     */
    public boolean hasKey(Object key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            logger.error("redis hasKey:{} error", key);
            return false;
        }
    }

    /**
     * 删除key
     *
     * @param key
     */
    public void del(String... key) {
        try {
            if (key != null && key.length > 0) {
                if (key.length == 1) {
                    redisTemplate.delete(key[0]);
                } else {
                    redisTemplate.delete(CollectionUtils.arrayToList(key));
                }
            }
        } catch (Exception e) {
            logger.error("redis delKey:{} error", key);
        }
    }

    /**
     * 通过key获取value
     *
     * @param key
     * @return
     */
    public Object getValue(Object key) {
        try {
            return key == null ? null : redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            logger.error("redis getValue key:{} error", key);
            return null;
        }
    }


    /**
     * 键值对存入
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(Object key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            logger.error("redis set key:{} , value:{} error", key, value);
            return false;
        }
    }


    /**
     * 普通缓存放入
     *
     * @param key   键
     * @param value 值
     * @return true成功 false失败
     */
    public boolean set(String key, Object value, long outTime, TimeUnit timeUnit) {
        try {
            if (outTime > 0) {
                redisTemplate.opsForValue().set(key, value, outTime, timeUnit);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            logger.error("redis set key:{} , value:{} , outTime:{} , TimeUnit:{}error", key, value, outTime, timeUnit);
            return false;
        }
    }
}
