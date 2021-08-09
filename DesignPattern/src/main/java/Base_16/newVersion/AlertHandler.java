package Base_16.newVersion;

import Base_16.oldVersion.AlertRoles;
import Base_16.oldVersion.Notification;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public abstract class AlertHandler {
    //报警规则
    protected AlertRoles rule;
    //报警渠道
    protected Notification notification;

    public AlertHandler(AlertRoles rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    public abstract void check(ApiInfoParams apiInfoParams);
}
