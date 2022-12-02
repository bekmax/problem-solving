package leetcode.trees;

/**
 * N110 Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.
 */

public class EasyBalancedBinaryTree {
    public static void main(String[] args) {

    }

    class Solution {
        int max = 0;

        public boolean isBalanced(TreeNode root) {
            dfs(root);
            if (max > 1) return false;
            return true;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = dfs(root.left) + 1;
            int right = dfs(root.right) + 1;
            max = Math.max(max, Math.abs(left - right));
            return Math.max(left, right);
        }
    }

    public class TreeNode {
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
}
