package Base_16.oldVersion;


/**
 * 功能说明：API接口报警类
 * 开发人员：@Author MaLi
 */
public class Alert {
    //报警规则
    private AlertRoles rule;
    //报警渠道
    private Notification notification;

    public Alert(AlertRoles rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    public void check(String api, long requestCount, long errorCount, long durationOfSeconds) {
        long tps = requestCount / durationOfSeconds;
        if (tps > rule.getMatchedRule(api).getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
        if (errorCount > rule.getMatchedRule(api).getMaxErrorCount()) {
            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
        }
    }
}
