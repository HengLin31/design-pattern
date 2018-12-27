package pers.henglin.design.pattern.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pers.henglin.design.pattern.visitor.bean.IntegerTreeNode;
import pers.henglin.design.pattern.visitor.bean.StringTreeNode;
import pers.henglin.design.pattern.visitor.impl.TreeNode;

import java.util.Optional;

public class TreeFactory {
    private static final Logger LOG = LoggerFactory.getLogger(TreeFactory.class);

    private static final String INTEGER = "class java.lang.Integer";
    private static final String STRING = "class java.lang.String";

    private static final String CLASS_PATH = "pers.henglin.design.pattern.visitor.bean.";
    private static final String CLASS_PATH_INTEGER_TREE_NODE = CLASS_PATH + "IntegerTreeNode";
    private static final String CLASS_PATH_String_TREE_NODE = CLASS_PATH + "StringTreeNode";

    public static Optional<TreeNode> init(Object[] values){
        if((null == values) || (0 == values.length)){
            return Optional.empty();
        }
        Object type = values[0];
        switch(type.getClass().toString()){
            case INTEGER:
                TreeNode<Integer> integerTreeNode = new IntegerTreeNode();
                return Optional.ofNullable(insert(CLASS_PATH_INTEGER_TREE_NODE, values, integerTreeNode, 0));
            case STRING:
                StringTreeNode stringTreeNode = new StringTreeNode();
                return Optional.ofNullable(insert(CLASS_PATH_String_TREE_NODE, values, stringTreeNode, 0));
            default:
                LOG.warn("can't find this implement class: {}", type.getClass().toString());
        }
        return Optional.empty();
    }

    private static TreeNode<?> insert(String classPath, Object[] values, TreeNode root, int index){
        if(index < values.length){
            try {
                Class<?> clazz = Class.forName(classPath);
                TreeNode<?> tempTreeNode = (TreeNode<?>) clazz.newInstance();

                tempTreeNode.setValue(values[index]);
                root = tempTreeNode;

                root.setLeft(insert(classPath, values, root.getLeft(), (2 * index) + 1));
                root.setRight(insert(classPath, values, root.getRight(), (2 * index) + 2));
            } catch (Exception e) {
                LOG.warn("class reflection: {}", e);
            }
        }
        return root;
    }
}
