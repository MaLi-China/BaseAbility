package P02;

import lombok.Data;

/**
 * 功能说明：封装Bean
 * 开发人员：@author MaLi
 */
@Data
public class Token {
    private TokenType type;
    private String text;
}
