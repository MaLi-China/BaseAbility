package v1;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public enum StateCode {
    SUCCESS(200, "OK"),
    ERROR(404, "Not Found");

    StateCode(int i, String state) {
    }
}
