package Builder.v1.coat;

import Builder.v1.Matter;

import java.math.BigDecimal;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public class DuluxCoat implements Matter {
    @Override
    public String scene() {
        return "涂料";
    }

    @Override
    public String brand() {
        return "多乐士(Dulux)";
    }

    @Override
    public String model() {
        return "第二代";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(719);
    }

    @Override
    public String desc() {
        return "畅销全球100多个国家";
    }
}
