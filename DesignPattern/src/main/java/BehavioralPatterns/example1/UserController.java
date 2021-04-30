package BehavioralPatterns.example1;

/**
 * 功能说明：模拟控制层代码
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/4/30
 */
public class UserController {
    private UserService userService;
    private PromotionService promotionService;

    /**
     * 用户注册
     *
     * @param telephone 电话号码
     * @param password  密码
     * @return 用户id
     */
    public long register(String telephone, String password) {
        /*
            违反单一职责原则: 注册和发放体验金作为不同逻辑, 都放在了注册接口
            如果, 该需求发生变动, 改为发送红包或者其它促销措施, 就必须修改该接口 --> 违反开闭原则
            如果, 需求不断增多, 该接口内容会越来越多, 不易维护, 影响可读性
            使用template2包中的设计模式解决: 观察者设计模式
         */
        long userId = userService.register(telephone, password);
        promotionService.issueNewUserExperienceCash(userId);
        return userId;
    }
}
