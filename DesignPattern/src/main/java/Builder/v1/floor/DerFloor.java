package Builder.v1.floor;

import Builder.v1.Matter;

import java.math.BigDecimal;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public class DerFloor implements Matter {
    @Override
    public String scene() {
        return "地板";
    }

    @Override
    public String brand() {
        return "德尔(Der)";
    }

    @Override
    public String model() {
        return "A+";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(119);
    }

    @Override
    public String desc() {
        return "专业木地板制造商";
    }
}
