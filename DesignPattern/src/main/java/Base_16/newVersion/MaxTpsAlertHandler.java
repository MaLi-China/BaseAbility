package Base_16.newVersion;

import Base_16.oldVersion.AlertRoles;
import Base_16.oldVersion.Notification;
import Base_16.oldVersion.NotificationEmergencyLevel;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public class MaxTpsAlertHandler extends AlertHandler {
    public MaxTpsAlertHandler(AlertRoles rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiInfoParams apiInfoParams) {
        long tps = apiInfoParams.getRequestCount() / apiInfoParams.getDurationOfSeconds();
        if (tps > rule.getMatchedRule(apiInfoParams.getApi()).getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
    }
}
