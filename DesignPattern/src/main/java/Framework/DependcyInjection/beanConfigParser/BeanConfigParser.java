package Framework.DependcyInjection.beanConfigParser;

import Framework.DependcyInjection.domain.BeanDefinition;

import java.io.InputStream;
import java.util.List;

/**
 * 功能说明：配置文件解析类
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/2
 */
public interface BeanConfigParser {
    List<BeanDefinition> parse(InputStream in);
}
