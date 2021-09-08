package DP07_Observer.Example01_P2P;

/**
 * 功能说明：模拟Controller层的注册
 * --不用观察者的情况
 * 开发人员：@author MaLi
 */
public class UserController {
    // 以下两个属性, 通过Spring注入
    private UserService userService;
    private PromotionService promotionService;

    /**
     * 三层架构: Controller层
     *
     * @param telephone 电话
     * @param password  密码
     * @return userId userId
     */
    public Long register(String telephone, String password) {
        //注册
        long userId = userService.register(telephone, password);
        //推广活动:体 验 金(以后可能还有优惠券, 站内信)
        promotionService.issueNewUserExperienceCash(userId);
        return userId;
    }
}
