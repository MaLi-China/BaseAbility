package AbstractFactory.bugstack.application2;

import java.util.concurrent.TimeUnit;

/**
 * 功能说明：模拟使用单机Redis
 * 开发人员：@Author MaLi
 */
public interface CacheService {


    String get(String key, int redisType);

    void set(String key, String value, int redisType);

    void set(String key, String value, long timeout, TimeUnit timeUnit, int redisType);

    void del(String key, int redisType);
}
