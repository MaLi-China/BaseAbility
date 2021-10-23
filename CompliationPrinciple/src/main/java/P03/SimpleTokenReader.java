package P03;

import P02.Token;

import java.util.List;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class SimpleTokenReader implements TokenReader {
    private List<Token> tokens;
    private int position;

    public SimpleTokenReader(List<Token> tokens) { //传入词法解析器中的Token列表
        this.position = 0;
        this.tokens = tokens;
    }

    @Override
    public Token read() {
        Token token = position < tokens.size() ? tokens.get(position++) : null;
        System.out.println("" + token);
        return token;
    }

    @Override
    public Token peek() {
        return position < tokens.size() ? tokens.get(position) : null;
    }

    @Override
    public void unread() {
        if (position > 0) {
            position--;
        }
    }

    @Override
    public int getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(int position) {
        if (position >= 0 && position < tokens.size()) {
            this.position = position;
        }
    }
}
