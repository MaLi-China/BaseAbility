package BehavioralPatterns.example1;

/**
 * 功能说明：模拟业务层代码
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/4/30
 */
public interface UserService {
    /**
     * 模拟注册操作
     *
     * @param telephone 电话号码
     * @param password  密码
     * @return 用户userid
     */
    long register(String telephone, String password);
}
