package DP20_Bridge.SimpleExample;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public abstract class Car {
    protected Transmission transmission;

    public Car(Transmission transmission) {
        this.transmission = transmission;
    }

    abstract void run();
}
