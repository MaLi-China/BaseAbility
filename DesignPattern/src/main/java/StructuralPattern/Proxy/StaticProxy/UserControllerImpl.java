package StructuralPattern.Proxy.StaticProxy;

import StructuralPattern.Proxy.IUserController;

/**
 * 功能说明：模拟一个具体的UserController
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/3
 */
public class UserControllerImpl implements IUserController {
    @Override
    public void login(String telephone, String password) {
        System.out.println("UserControllerImpl do login method");
    }

    @Override
    public void register(String telephone, String password) {
        System.out.println("UserControllerImpl do register method");
    }
}
