package com.licslan.week04.BST;
/**
 * @author LICSLAN 下定决心学算法与数据结构
 * */
public class BinarySearchTree<E extends Comparable<E>> {

    //二分搜索树是二叉树  右子树>左子树  存储元素必须有可比性  天然递归性

    /**私有节点类型定一下*/
    private class Node{
        public E e;
        public Node left,right;
        /**构造方法*/
        public Node(E e){
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }
    /**二分搜索树其他成员变量 根节点*/
    private Node root;
    /**二分搜索树成员变量存储了多少个节点*/
    private int size;
    /**二分搜索树的构造函数 这个和默认的构造函数效果一样的*/
    public BinarySearchTree(){
        //一个元素也没有存
        root=null;
        size=0;
    }
    /**二分搜索树成员函数 获取当前二分搜索树的元素*/
    public int size(){
        return size;
    }
    /**判断当前二分搜索树是否为空*/
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 二分搜索树添加新元素  此时该类实现不好含重复的元素
     * 如果想包含重复的 元素，需要定义左子树《=节点 or 右子树>=节点  注意数组/链表 可以有重复元素
     * 二分搜索树添加元素的非递归写法 和链表很像
     * */

    //向二分搜索树中插入元素E 递归算法
    public void add(E e){
        //根节点为空
        if(root == null){
            root=new Node(e);
            size++;
        }else add(root,e);
    }

    //向以node为根的二分搜索树中插入元素E 递归算法
    private void add(Node node, E e) {
        //如果已经存在
        if (node.equals(e))return;
        //左子树不存在，放在左子树
        else if(node.e.compareTo(e)<0&&node.left==null){node.left=new Node(e);size++;return;}
        //右子树不存在，放在右子树
        else if(node.e.compareTo(e)>0&&node.right == null){node.right = new Node(e);size++;return;}

        //左子树不为空
        if (node.e.compareTo(e) < 0) {
            add(node.left, e);
        }else
        //右子树不为空
            add(node.right,e);
    }

    /**null本身也是一颗树不用向上面那样去判断了 不用对root为空进行判断*/
    public void add1(E e){
        add1(root,e);
    }

    /**返回插入新节点后二分搜索树的根*/
    private Node add1(Node node, E e) {
        if(node==null){
            size++;
            return new Node(e);
        }

        if(node.e.compareTo(e)<0){
            node.left=add1(node.left, e);
        }else if(node.e.compareTo(e) > 0) {
            node.right = add1(node.right, e);
        }

        return node;
    }

}
