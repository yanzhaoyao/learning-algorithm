package cn.lucas.learning.algorithm.binary.tree;

/**
 * Definition for a binary tree node.
 *
 * @author lucas
 * @date 2020-10-27
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
