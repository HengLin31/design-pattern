package pers.henglin.design.pattern.visitor.impl;

public interface TreeNode<T> {
    void setLeft(TreeNode<T> treeNode);
    void setRight(TreeNode<T> treeNode);
    void setValue(T value);

    TreeNode<T> getLeft();
    TreeNode<T> getRight();
    T getValue();

    void accept(TreeVisitor visitor);
}
