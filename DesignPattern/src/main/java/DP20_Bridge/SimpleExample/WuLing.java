package DP20_Bridge.SimpleExample;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class WuLing extends Car {
    public WuLing(Transmission transmission) {
        super(transmission);
    }

    @Override
    void run() {
        this.transmission.transmit();
        System.out.println("BMW is running...");
    }
}
