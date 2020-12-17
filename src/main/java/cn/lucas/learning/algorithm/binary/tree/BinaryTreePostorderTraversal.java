package cn.lucas.learning.algorithm.binary.tree;

import cn.lucas.learning.algorithm.node.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树|二叉树的后序遍历
 *
 * @author lucas
 * @date 2020-10-26
 * @link leetcode : <https://leetcode-cn.com/problems/binary-tree-postorder-traversal/>
 * <p>
 * <>https://blog.csdn.net/u013834525/article/details/80421684</>
 * <p>
 * 1. 为什么叫前序、后序、中序？
 * <p>
 * 一棵二叉树由根结点、左子树和右子树三部分组成，若规定 D、L、R 分别代表遍历根结点、遍历左子树、遍历右子树，则二叉树的遍历方式有 6 种：DLR、DRL、LDR、LRD、RDL、RLD。由于先遍历左子树和先遍历右子树在算法设计上没有本质区别，所以，只讨论三种方式：
 * <p>
 * DLR--前序遍历（根在前，从左往右，一棵树的根永远在左子树前面，左子树又永远在右子树前面 ）
 * <p>
 * LDR--中序遍历（根在中，从左往右，一棵树的左子树永远在根前面，根永远在右子树前面）
 * <p>
 * LRD--后序遍历（根在后，从左往右，一棵树的左子树永远在右子树前面，右子树永远在根前面）
 */
public class BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        TreeNode right = new TreeNode(2, new TreeNode(3), null);
        TreeNode root = new TreeNode(1, null, right);
        System.out.println(new BinaryTreePostorderTraversal().postorderTraversal(root));
        System.out.println(new BinaryTreePostorderTraversal().postorderTraversal2(root));
    }

    /**
     * 后序递归|断子绝孙法
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.peek();
            if (current.left == null && current.right == null) {
                result.add(stack.pop().val);
            }
            if (current.right != null) {
                stack.push(current.right);
                current.right = null;
            }
            if (current.left != null) {
                stack.push(current.left);
                current.left = null;
            }
        }
        return result;
    }

    /**
     * 后序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }

}

