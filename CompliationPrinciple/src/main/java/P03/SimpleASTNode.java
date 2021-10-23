package P03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class SimpleASTNode implements ASTNode {
    private SimpleASTNode parent;
    private List<ASTNode> children;
    private List<ASTNode> readOnlyChildren;
    private ASTNodeType nodeType;

    public SimpleASTNode(ASTNodeType nodeType, String nodeText) {
        this.parent = null;
        this.children = new ArrayList<>();
        this.readOnlyChildren = Collections.unmodifiableList(children);
        this.nodeType = nodeType;
        this.nodeText = nodeText;
    }

    private String nodeText;

    @Override
    public ASTNode getParent() {
        return this.parent;
    }

    @Override
    public List<ASTNode> getChildren() {
        return this.readOnlyChildren;
    }

    public void addChilden(SimpleASTNode child) {
        children.add(child);
        child.parent = this;
    }

    @Override
    public ASTNodeType getType() {
        return this.nodeType;
    }

    @Override
    public String getText() {
        return this.nodeText;
    }
}
