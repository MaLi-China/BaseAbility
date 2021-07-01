package Builder.v1;

import java.math.BigDecimal;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public interface Matter {
    String scene();//场景: 地板, 地砖, 涂料, 吊顶

    String brand(); // 品牌

    String model(); // 型号

    BigDecimal price();// 价格

    String desc();//描述
}
