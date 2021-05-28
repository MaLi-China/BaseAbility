package AbstractFactory.restructure.workshop.impl;

import AbstractFactory.bugstack.redis.cluster.EGM;
import AbstractFactory.restructure.workshop.ICacheAdapter;

import java.util.concurrent.TimeUnit;

/**
 * 功能说明：EGM集群的适配器
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/25
 */
public class EGMCacheAdapter implements ICacheAdapter {
    private EGM egm = new EGM();

    @Override
    public String get(String key) {
        return egm.gain(key);
    }

    @Override
    public void set(String key, String value) {
        egm.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        egm.setEx(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        egm.delete(key);
    }
}
