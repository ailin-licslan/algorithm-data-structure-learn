package com.licslan.interview.leetcode500.tree;

import com.licslan.interview.hot100.utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author licslan  LeetCode 专栏  ♥  NO145
 * 1.先序(根)遍历
 * 先序遍历(D-L-R)，按照根左右的顺序沿一定路径经过路径上所有的结点。在二叉树中，先根后左再右。
 * 巧记：根左右
 * <p>
 * 2.中序遍历（LDR）,按照左根右的顺序沿一定路径经过路径上所有的结点，中序遍历首先遍历左子树，然后访问根结点，最后遍历右子树，
 * 巧记：左根右
 * <p>
 * 3.后序遍历（LRD）,按照左右根的顺序沿一定路径经过路径上所有的结点，后序遍历首先遍历左子树，然后访问右子树，最后遍历根结点，
 * 巧记：左右根。
 */
public class Loop2TreeAfter145 {

    List<Integer> res = new LinkedList<>();

    //左右根

    public List<Integer> postOrderTraversal(TreeNode root) {
        //1 ROOT 2 LEFT 3 RIGHT
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            res.add(root.val);
        }
        return res;
    }


    //利用栈 循环实现

    public List<Integer> postOrderTraversal2(TreeNode root) {
        //1 LEFT 2 RIGHT  3 ROOT  左右根
        List<Integer> resList = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        //表示前一个访问的节点
        TreeNode prevAccess = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prevAccess) {
                resList.add(root.val);
                prevAccess = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return resList;
    }
}
