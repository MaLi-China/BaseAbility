package DP07_Observer.Example04_P2P_multiThreadv2;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class Main {
    public static void main(String[] args) {
        RegPromotionObserver regPromotionObserver = new RegPromotionObserver();
        RegNotificationObserver regNotificationObserver = new RegNotificationObserver();
        List<IRegObserver> observers = new ArrayList<>();
        observers.add(regNotificationObserver);
        observers.add(regPromotionObserver);
        UserController userController = new UserController();
        userController.setRegObservers(observers);
        Long userId = userController.register("88888", "88888");
        System.out.println("main...");
    }
}
