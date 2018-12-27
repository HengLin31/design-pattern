package pers.henglin.design.pattern.visitor

import pers.henglin.design.pattern.visitor.impl.TreeNode
import spock.lang.Specification

class VisitorTest extends Specification {
    def "test tree traversal: Integer"() {
        setup:
        Optional<TreeNode> root = TreeFactory.init([0, 1, 2, 3, 4, 5, 6, 7, 8] as Integer[])

        when:
        TreeTraversal treeTraversal = new TreeTraversal()
        treeTraversal.visit(root.get())

        then:
        treeTraversal.getLog() == "0 -> 1 -> 3 -> 7 -> 8 -> 4 -> 2 -> 5 -> 6 -> "
    }

    def "test tree traversal: String"() {
        setup:
        Optional<TreeNode> root = TreeFactory.init(["0", "1", "2", "3", "4", "5", "6", "7", "8"] as String[])

        when:
        TreeTraversal treeTraversal = new TreeTraversal()
        treeTraversal.visit(root.get())

        then:
        treeTraversal.getLog() == "0 -> 1 -> 3 -> 7 -> 8 -> 4 -> 2 -> 5 -> 6 -> "
    }
}
