package com.nengli51.facotry;

/**
 * 功能说明：代表容器的功能, 获取Bean实例
 * 开发人员：@author MaLi
 */
public interface BeanFactory {
    /**
     * 根据id获取容器中的Bean实例
     *
     * @param id 容器中的唯一Bean实例id
     * @return
     */
    Object getBean(String id);
}
