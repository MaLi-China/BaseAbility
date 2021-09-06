package DP02_Strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明：计算指标类
 * 开发人员：@author MaLi
 */
public class Calculation {
    private List<Executor> executors;

    public Calculation() {
        this.executors = new ArrayList<>();
    }

    public void addExecutor(Executor executor) {
        executors.add(executor);
    }

    public void calculate() {
        for (Executor executor : executors) {
            executor.execute();
        }
    }
}
