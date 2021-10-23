package P03;

import java.util.List;

/**
 * 功能说明：抽象语法树的结点
 * 开发人员：@author MaLi
 */
public interface ASTNode {
    SimpleASTNode parent = null;
    List<ASTNode> children = null;
    List<ASTNode> readOnlyChildren = null;
    ASTNodeType nodeType = null;

    /**
     * 获取父节点
     *
     * @return
     */
    ASTNode getParent();

    /**
     * 获取子节点
     *
     * @return
     */
    List<ASTNode> getChildren();


    /**
     * 获取结点类型
     *
     * @return
     */
    ASTNodeType getType();

    /**
     * 获取结点文本
     *
     * @return
     */
    String getText();


}
