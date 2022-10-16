package com.licslan.interview.hot100;

import com.licslan.interview.hot100.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WEILIN
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * <p>
 * <p>
 * 理解一
 * https://blog.csdn.net/weixin_45705162/article/details/108296417?spm=1001.2101.3001.6661.1&
 * utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-108296417-
 * blog-53188837.pc_relevant_default&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog
 * -2%7Edefault%7ECTRLIST%7ERate-1-108296417-blog-53188837.pc_relevant_default&utm_relevant_index=1
 * <p>
 * <p>
 * <p>
 * <p>
 * 理解 二
 * https://guangguang.blog.csdn.net/article/details/88077221?spm=1001.2101.3001.6650.1&utm_medium=distribute.
 * pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-88077221-blog-120711688.pc_relevant_3mothn_strategy_
 * and_data_recovery&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-8807722
 * 1-blog-120711688.pc_relevant_3mothn_strategy_and_data_recovery&utm_relevant_index=2
 */
public class MaxDepth104 {


    //递归

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    //BFS  bfs（广度优先搜索）

    /**
     * 从某一个顶点出发开始访问，被访问的顶点做相应的标记，输出访问顶点。
     * 从被访问的顶点出发，搜索与该顶点有边的关联的某个未被访问的邻接点，并做相应标记。
     * 再从根据上述中所有被访问的邻接点，访问与这些邻接点相关的未被访问的邻接点，直到所有顶点访问完为止
     */

    public int maxDepthV2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return level;
    }


    //DFS  dfs（深度优先搜索）


    /**
     * 从某一个顶点出发开始访问，被访问的顶点做相应的标记，输出访问顶点。
     * 从被访问的顶点出发，搜索与该顶点有边的关联的某个未被访问的邻接点。
     * 再从该邻接点出发进一步搜索与该顶点有边的关联的某个未被访问的邻接点，直到全部顶点访问完毕
     */
    int maxLevel = 0;

    public int maxDepthV3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 1);
        return maxLevel;
    }

    public void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level > maxLevel) {
            maxLevel = level;
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }


    /**
     * 总结
     * 1.BFS是用来搜索最短径路的解是比较合适的，比如求最少步数的解，最少交换次数的解，因为BFS搜索过程中遇到的解一定是离根最近的，
     * 所以遇到一个解，一定就是最优解，此时搜索算法可以终止。这个时候不适宜使用DFS，因为DFS搜索到的解不一定是离根最近的，
     * 只有全局搜索完毕，才能从所有解中找出离根的最近的解。（当然这个DFS的不足，可以使用迭代加深搜索ID-DFS去弥补）
     * 2.空间优劣上，DFS是有优势的，DFS不需要保存搜索过程中的状态，而BFS在搜索过程中需要保存搜索过的状态，而且一般情况需要一个队列来记录。
     * 3.DFS适合搜索全部的解，因为要搜索全部的解，那么BFS搜索过程中，遇到离根最近的解，并没有什么用，也必须遍历完整棵搜索树，
     * DFS搜索也会搜索全部，但是相比DFS不用记录过多信息，所以搜素全部解的问题，DFS显然更加合适
     * */
}
