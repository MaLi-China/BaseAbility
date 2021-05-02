package Framework.DependcyInjection.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明：配置对象(解析配置文件得到)
 * 开发人员：@Author MaLi
 * 开发日期：@Date  2021/5/2
 */
public class BeanDefinition {
    private String id;
    private String className;
    private List<ConstrctorArg> constrctorArgs = new ArrayList<>();
    private Scope singleton = Scope.SINGLETON;
    private boolean lazyInit = false;

    public boolean isSingleton() {
        return singleton == Scope.SINGLETON;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<ConstrctorArg> getConstrctorArgs() {
        return constrctorArgs;
    }

    public void setConstrctorArgs(List<ConstrctorArg> constrctorArgs) {
        this.constrctorArgs = constrctorArgs;
    }

    public Scope getSingleton() {
        return singleton;
    }

    public void setSingleton(Scope singleton) {
        this.singleton = singleton;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }

    public enum Scope {
        SINGLETON,
        PROTOTYPE
    }

    public static class ConstrctorArg {
        private boolean isRef;
        private Class type;
        private Object arg;

        public boolean isRef() {
            return isRef;
        }

        public void setRef(boolean ref) {
            isRef = ref;
        }

        public Class getType() {
            return type;
        }

        public void setType(Class type) {
            this.type = type;
        }

        public Object getArg() {
            return arg;
        }

        public void setArg(Object arg) {
            this.arg = arg;
        }
    }
}

