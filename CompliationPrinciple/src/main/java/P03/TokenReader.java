package P03;

import P02.Token;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public interface TokenReader {
    /**
     * 返回token流中下一个token, 并从流中取出.
     *
     * @return
     */
    Token read();

    /**
     * 返回token流中下一个token, "不" 从流中取出.
     *
     * @return
     */
    Token peek();

    /**
     * Token流回退异步
     */
    void unread();

    /**
     * 获取Token流当前的读取位置
     *
     * @return
     */
    int getPosition();

    /**
     * 设置Token流当前的位置
     */
    void setPosition(int position);

}
