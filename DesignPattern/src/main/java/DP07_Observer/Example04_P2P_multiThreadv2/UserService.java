package DP07_Observer.Example04_P2P_multiThreadv2;

/**
 * 功能说明：模拟UserService
 * 开发人员：@author MaLi
 */
public class UserService {
    public long register(String telephone, String password) {
        System.out.println("模拟UserService注册- 电话: " + telephone + " +password: ******" + password);
        return 99998888L;
    }
}
