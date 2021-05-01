package BehavioralPattern.Observer.example1;

/**
 * 功能说明：模拟service层促销服务
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/4/30
 */
public interface PromotionService {
    /**
     * 促销措施1: 发放体验金
     *
     * @param userId 用户ID
     */
    void issueNewUserExperienceCash(long userId);
}
