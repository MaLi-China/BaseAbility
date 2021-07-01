package Builder.v1.tile;

import Builder.v1.Matter;

import java.math.BigDecimal;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public class MarcoPoloTile implements Matter {
    @Override
    public String scene() {
        return "地砖";
    }

    @Override
    public String brand() {
        return "马可波罗";
    }

    @Override
    public String model() {
        return "默认";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(140);
    }

    @Override
    public String desc() {
        return "诞生于1996年";
    }
}
