package BehavioralPatterns.ObserverDesignPattern.template2.controller;

import BehavioralPatterns.ObserverDesignPattern.template2.observer.RegObserver;
import BehavioralPatterns.ObserverDesignPattern.template2.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明：应用观察者模式解耦不同行为(被观察者与观察者之间的不同行为)
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/4/30
 */
public class UserController {
    private UserService userService;

    //观察者容器
    private List<RegObserver> observers = new ArrayList<>();

    /**
     * 添加观察者
     *
     * @param observers 观察者
     */
    public void setRegObservers(List<RegObserver> observers) {
        this.observers.addAll(observers);
    }

    /**
     * 接收客户端调用, 执行注册业务
     *
     * @param telephone 电话号码
     * @param password  密码
     * @return 注册成功的用户id
     */
    public long register(String telephone, String password) {

        long userId = userService.register(telephone, password);
        for (RegObserver observer : observers) {
            observer.handleRegSuccess(userId);
        }
        return userId;
    }
}
