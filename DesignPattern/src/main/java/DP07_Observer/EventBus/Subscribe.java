package DP07_Observer.EventBus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 功能说明：用于标记在观察者方法上面的注解
 * 注解作用: 代表被标记的方法, 在合适的事件类型触发时, 被事件源调用
 * 开发人员：@author MaLi
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subscribe {
}
