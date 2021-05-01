package CreationalPattern.Builder.example;


import org.apache.commons.lang3.StringUtils;

/**
 * 功能说明：资源池配置类
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/2
 */
public class ResourcePoolConfig {
    private static final int DEFAULT_MAX_TOTAL = 8;
    private static final int DEFAULT_MAX_IDLE = 8;
    private static final int DEFAULT_MIN_IDLE = 0;

    private String name;
    private int maxTotal = DEFAULT_MAX_TOTAL;
    private int maxIdle = DEFAULT_MAX_IDLE;
    private int minIdle = DEFAULT_MIN_IDLE;

    /*
        必填项: name, 不设置会抛出异常
        存在问题: 构造函数的参数列表过长(后续可能还会增加)
     */
    public ResourcePoolConfig(String name, Integer maxTotal, Integer maxIdle, Integer minIdle) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("name should not empty!");
        }
        this.name = name;
        if (maxTotal != null) {
            if (maxTotal <= 0) {
                throw new IllegalArgumentException("maxTotal should be positive.");
            }
            this.maxTotal = maxTotal;
        }
        if (maxIdle != null) {
            if (maxIdle <= 0) {
                throw new IllegalArgumentException("maxIdle should not be negative.");
            }
            this.maxIdle = maxIdle;
        }
        if (minIdle != null) {
            if (minIdle < 0) {
                throw new IllegalArgumentException("minIdle should not be negative.");
            }
            this.minIdle = minIdle;
        }
    }
}
