package AbstractFactory.bugstack.application.impl;

import AbstractFactory.bugstack.application.CacheService;
import AbstractFactory.bugstack.redis.RedisUtils;

import java.util.concurrent.TimeUnit;

/**
 * 功能说明：单机Redis接口使用类的实现
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/25
 */
public class CacheServiceImpl implements CacheService {
    private RedisUtils redisUtils = new RedisUtils();

    @Override
    public String get(String key) {
        return redisUtils.get(key);
    }

    @Override
    public void set(String key, String value) {
        redisUtils.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        redisUtils.set(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        redisUtils.del(key);
    }
}
