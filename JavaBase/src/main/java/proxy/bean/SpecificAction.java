package proxy.bean;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class SpecificAction implements IAction {
    @Override
    public void doaction() {
        System.out.println("SpecificAction...");
    }
}
