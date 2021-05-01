package CreationalPattern.Builder.example;


import org.apache.commons.lang3.StringUtils;

/**
 * 功能说明：资源池配置类 - 改进(之前的类, 构造函数参数列表过长, 现在使用setter函数来设置, 提高可读性)
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/2
 */

public class ResourcePoolConfig_V1_1 {
    private static final Integer DEFAULT_MAX_TOTAL = 8;
    private static final Integer DEFAULT_MAX_IDLE = 8;
    private static final Integer DEFAULT_MIN_IDLE = 0;

    private String name;
    private Integer maxTotal = DEFAULT_MAX_TOTAL;
    private Integer maxIdle = DEFAULT_MAX_IDLE;
    private Integer minIdle = DEFAULT_MIN_IDLE;

    /*
        必填项: name, 不设置会抛出异常
        存在问题: 构造函数的参数列表过长(后续可能还会增加)
     */
    public ResourcePoolConfig_V1_1(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("name should not empty!");
        }
        this.name = name;
    }

    public void setMaxTotal(Integer maxTotal) {
        if (maxTotal != null) {
            if (maxTotal <= 0) {
                throw new IllegalArgumentException("maxTotal should be positive.");
            }
            this.maxTotal = maxTotal;
        }
    }

    public void setMaxIdle(Integer maxIdle) {
        if (maxIdle != null) {
            if (maxTotal <= 0) {
                throw new IllegalArgumentException("maxIdle should not be negative.");
            }
            this.maxIdle = maxIdle;
        }
    }

    public void setMinIdle(Integer minIdle) {
        if (minIdle != null) {
            if (maxTotal < 0) {
                throw new IllegalArgumentException("minIdle should not be negative.");
            }
            this.minIdle = minIdle;
        }
    }
}