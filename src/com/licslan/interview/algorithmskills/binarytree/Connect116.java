package com.licslan.interview.algorithmskills.binarytree;

public class Connect116 {

    //抽象成一个三叉树
    public Node connect(Node root) {
        if (root == null) return null;
        traverse(root.left, root.right);
        return root;

    }

    void traverse(Node node1, Node node2) {

        if (node1 == null || node2 == null) return;

        //前序位置

        //将传入的2个节点连接起来
        node1.next = node2;

        //连接相同父节点的两个子节点
        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);
        //连接跨越父节点的2个子节点
        traverse(node1.right, node2.left);
    }

}
