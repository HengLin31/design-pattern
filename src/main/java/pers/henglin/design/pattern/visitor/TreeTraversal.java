package pers.henglin.design.pattern.visitor;

import pers.henglin.design.pattern.Constant;
import pers.henglin.design.pattern.visitor.impl.Log;
import pers.henglin.design.pattern.visitor.impl.TreeNode;
import pers.henglin.design.pattern.visitor.impl.TreeVisitor;

public class TreeTraversal implements TreeVisitor, Log {
    private StringBuilder log = new StringBuilder();

    @Override
    public void visit(TreeNode treeNode) {
        if(null == treeNode){
            return;
        }

        appendLog(String.valueOf(treeNode.getValue()));

        TreeNode leftNode = treeNode.getLeft();
        if(null != leftNode){
            leftNode.accept(this);
        }

        TreeNode rightNode = treeNode.getRight();
        if(null != rightNode){
            rightNode.accept(this);
        }
    }

    @Override
    public String getLog() {
        return log.toString();
    }

    @Override
    public void appendLog(String log) {
        this.log.append(log).append(Constant.NODE_NEXT_POINT);
    }
}
