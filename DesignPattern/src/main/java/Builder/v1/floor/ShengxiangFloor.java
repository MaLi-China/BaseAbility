package Builder.v1.floor;

import Builder.v1.Matter;

import java.math.BigDecimal;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public class ShengxiangFloor implements Matter {
    @Override
    public String scene() {
        return "地板";
    }

    @Override
    public String brand() {
        return "圣象";
    }

    @Override
    public String model() {
        return "一级";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(318);
    }

    @Override
    public String desc() {
        return "中国驰名商标";
    }
}
