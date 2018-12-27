package pers.henglin.design.pattern.visitor;

import pers.henglin.design.pattern.visitor.bean.IntegerTreeNode;
import pers.henglin.design.pattern.visitor.bean.StringTreeNode;
import pers.henglin.design.pattern.visitor.impl.TreeNode;

import java.util.Optional;

public class TreeFactory {
    private static final String INTEGER = "class java.lang.Integer";
    private static final String STRING = "class java.lang.String";

    public static Optional<TreeNode> init(Object[] values){
        if((null == values) || (0 == values.length)){
            return Optional.empty();
        }
        Object type = values[0];
        switch(type.getClass().toString()){
            case INTEGER:
                TreeNode<Integer> integerTreeNode = new IntegerTreeNode();
                return Optional.ofNullable(insert((Integer[]) values, integerTreeNode, 0));
            case STRING:
                StringTreeNode stringTreeNode = new StringTreeNode();
                return Optional.ofNullable(insert((String[]) values, stringTreeNode, 0));
            default:
                System.out.println(type.getClass().toString());
        }
        return Optional.empty();
    }

    private static TreeNode<Integer> insert(Integer[] values, TreeNode<Integer> root, int index){
        if(index < values.length){
            TreeNode<Integer> temp = new IntegerTreeNode();
            temp.setValue(values[index]);
            root = temp;

            root.setLeft(insert(values, root.getLeft(), (2 * index) + 1));
            root.setRight(insert(values, root.getRight(), (2 * index) + 2));
        }
        return root;
    }

    private static TreeNode<String> insert(String[] values, TreeNode<String> root, int index){
        if(index < values.length){
            TreeNode<String> temp = new StringTreeNode();
            temp.setValue(values[index]);
            root = temp;

            root.setLeft(insert(values, root.getLeft(), (2 * index) + 1));
            root.setRight(insert(values, root.getRight(), (2 * index) + 2));
        }
        return root;
    }
}
