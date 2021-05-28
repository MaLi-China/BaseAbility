package AbstractFactory.bugstack.application;

import java.util.concurrent.TimeUnit;

/**
 * 功能说明：模拟使用单机Redis
 * 开发人员：@Author MaLi
 */
public interface CacheService {
    String get(final String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);
}
