package AbstractFactory.restructure.workshop.impl;

import AbstractFactory.bugstack.redis.cluster.IIR;
import AbstractFactory.restructure.workshop.ICacheAdapter;

import java.util.concurrent.TimeUnit;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/25
 */
public class IIRCacheAdapter implements ICacheAdapter {
    private IIR iir = new IIR();

    @Override
    public String get(String key) {
        return iir.get(key);
    }

    @Override
    public void set(String key, String value) {
        iir.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        iir.setExpire(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        iir.del(key);
    }
}
