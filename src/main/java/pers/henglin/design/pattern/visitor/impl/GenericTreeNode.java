package pers.henglin.design.pattern.visitor.impl;

public abstract class GenericTreeNode<T> implements TreeNode<T> {
    private T value;
    private TreeNode<T> leftNode;
    private TreeNode<T> rightNode;

    @Override
    public void setLeft(TreeNode<T> treeNode) {
        this.leftNode =  treeNode;
    }

    @Override
    public void setRight(TreeNode treeNode) {
        this.rightNode = treeNode;
    }

    @Override
    public void setValue(Object value) {
        this.value = (T) value;
    }

    @Override
    public TreeNode<T> getLeft() {
        return leftNode;
    }

    @Override
    public TreeNode<T> getRight() {
        return rightNode;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void accept(TreeVisitor visitor) {
        visitor.visit(this);
    }
}
