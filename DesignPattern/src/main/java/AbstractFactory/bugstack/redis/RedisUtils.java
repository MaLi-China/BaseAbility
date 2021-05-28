package AbstractFactory.bugstack.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 功能说明：模拟Redis单机服务: 使用Redis提供缓存服务
 * 开发人员：@Author MaLi
 */
public class RedisUtils {
    private Logger logger = LoggerFactory.getLogger(RedisUtils.class);
    private Map<String, String> dataMap = new ConcurrentHashMap<String, String>();

    public String get(String key) {
        logger.info("Redis获取数据key:{}", key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        logger.info("Redis写入数据key:{},value:{}", key, value);
        dataMap.put(key, value);
    }

    public void del(String key) {
        logger.info("Redis删除数据key:{}", key);
        dataMap.remove(key);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        logger.info("Redis写入数据key:{}, value:{}, timeout:{}, timeUnit:{}", key, value, timeout, timeUnit);
        dataMap.put(key, value);
    }
}
