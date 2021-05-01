package CreationalPattern.Builder.homework;

/**
 * 功能说明：在下面的 ConstructorArg 类中，
 * 1, 当 isRef 为 true 的时候，arg 表示 String 类型的 refBeanId，type 不需要设置；
 * 2, 当 isRef 为 false 的时候，arg、type 都需要设置。请根据这个需求，完善 ConstructorArg 类。
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/2
 */
public class ConstructorArg {
    private boolean isRef;
    private Class type;
    private Object arg;

    public ConstructorArg(ConstructorArgBuilder builder) {
        this.isRef = builder.isRef;
        this.type = builder.type;
        this.arg = builder.arg;
    }

    public static class ConstructorArgBuilder {
        private boolean isRef;
        private Class type;
        private Object arg;

        public ConstructorArg build() {
            //做校验逻辑
            if (isRef) {
                if (!(this.arg instanceof String)) {
                    throw new IllegalArgumentException("arg should be instance of refBeanId String!");
                }
            } else {
                if (arg == null || type == null) {
                    throw new IllegalArgumentException("arg and type should not be null!");
                }
            }
            return new ConstructorArg(this);
        }

        public ConstructorArgBuilder setRef(boolean ref) {
            this.isRef = ref;
            return this;
        }

        public ConstructorArgBuilder setType(Class type) {
            this.type = type;
            return this;
        }

        public ConstructorArgBuilder setArg(Object arg) {
            this.arg = arg;
            return this;
        }
    }
}
