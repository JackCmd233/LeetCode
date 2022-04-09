package OldCode.TheSecond.Number114;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 *
 * 114. 二叉树展开为链表
 *
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *  
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 *
 */
public class Solution1 {
    public static void main(String[] args) {


        TreeNode t3 = new TreeNode(3, null, null);
        TreeNode t4 = new TreeNode(4, null, null);

        TreeNode t6 = new TreeNode(6, null, null);
        TreeNode t5 = new TreeNode(5, null, t6);
        TreeNode t2 = new TreeNode(2, t3, t4);
        TreeNode t1 = new TreeNode(1, t2, t5);

        flatten(t1);
    }

    /**
     * 树的遍历,左优先,先序遍历
     * 采用迭代遍历
     */
    public static void flatten(TreeNode root) {
        List<TreeNode> result = new LinkedList<TreeNode>();
        getNodeVal(result, root);
        //把一维数组 转换为 树, 同时左侧子树全为空

        for (int i = 0; i < result.size(); i++) {
            TreeNode cur = result.get(i);
            cur.left = null;
            if (i + 1 < result.size()) {
                cur.right = result.get(i + 1);
            }
        }

    }


    /**
     * 左优先,先序遍历, 只能是原地调用,不能申请更多的内存空间
     */
    public static void getNodeVal(List<TreeNode> result, TreeNode root) {
        if (root != null) {
            result.add(root);
            getNodeVal(result,root.left);
            getNodeVal(result, root.right);
        }
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}














