package AbstractFactory.restructure.workshop;

import java.util.concurrent.TimeUnit;

/**
 * 功能说明：适配器接口
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/25
 */
public interface ICacheAdapter {
    String get(final String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);
}
