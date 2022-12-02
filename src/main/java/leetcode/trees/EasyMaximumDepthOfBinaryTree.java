package leetcode.trees;

/**
 * N104 Maximum Depth Of Binary Tree
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest
 * path from the root node down to the farthest leaf node.
 */
public class EasyMaximumDepthOfBinaryTree {
    public static void main(String[] args) {

    }

    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftDepth = maxDepth(root.left) + 1;
            int rightDepth = maxDepth(root.right) + 1;

            return Math.max(leftDepth, rightDepth);
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
