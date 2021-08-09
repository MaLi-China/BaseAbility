package Base_16.newVersion;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public class Alert {
    private List<AlertHandler> alertHandlers = new ArrayList<>();

    public void addHandler(AlertHandler alertHandlerlertHandler) {
        alertHandlers.add(alertHandlerlertHandler);
    }

    public void check(ApiInfoParams apiInfoParams) {
        for (AlertHandler handler : alertHandlers) {
            handler.check(apiInfoParams);
        }
    }
}
