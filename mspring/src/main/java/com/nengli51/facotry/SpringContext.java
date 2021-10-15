package com.nengli51.facotry;

/**
 * 功能说明：构建者
 * 开发人员：@author MaLi
 */
public class SpringContext {
    private static SpringContext springContext = new SpringContext();
    private static boolean parsed = false;

    private SpringContext() {
    }

    public static SpringContext getInstance(String path) {
        if (!parsed) {
            synchronized (SpringContext.class) {
                BeanFactory.parse(path);
                parsed = !parsed;
            }
        }
        return springContext;
    }

    public Object getBean(String beanId) {
        return BeanFactory.getBean(beanId);
    }
}
