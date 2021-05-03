package StructuralPattern.Proxy;

/**
 * 功能说明：模拟控制层接口UserController
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/3
 */
public interface IUserController {
    /**
     * 模拟登陆
     *
     * @param telephone
     * @param password
     */
    void login(String telephone, String password);

    /**
     * 模拟注册
     *
     * @param telephone
     * @param password
     */
    void register(String telephone, String password);

}
