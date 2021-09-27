package DP20_Bridge.SimpleExample;

import org.junit.Test;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class MainTest {
    @Test
    public void TM01_run() {
        Transmission transmission = new ManTransmission();
        Car car = new BMWCar(transmission);
        car.run();
        car = new BMWCar(new AutoTransmission());
        car.run();
    }
}
