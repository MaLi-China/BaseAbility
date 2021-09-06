package DP02_Strategy;

/**
 * 功能说明: 模拟指标计算中的不断变化的逻辑
 * 场景: 使用Storm进行实时计算, 替代之前数仓中的SQL语句, 需要翻译成为Java代码;
 * 每个指标都需要进行上面的代换, 如果一个指标写一段代码逻辑, 面对经常变化的需求, 代码则不具备扩展性
 * 于是, 使用策略设计模式, 重构之前的SQL翻译代码.
 * 开发人员：@author MaLi
 */
public interface Executor {
    void execute();
}
