package leetcode.trees;

/**
 * N572 Subtree of Another Tree
 * Given the roots of two binary trees root and subRoot,
 * return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants.
 * The tree tree could also be considered as a subtree of itself.
 */
public class EasySubtreeOfAnotherTree {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root == null){
                return false;
            }
            boolean isSame = isSame(root, subRoot);
            return isSame || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        private boolean isSame(TreeNode a, TreeNode b) {
            if (a == null && b == null) {
                return true;
            } else if (a == null) {
                return false;
            } else if (b == null) {
                return false;
            } else if (a.val != b.val) {
                return false;
            }
            return isSame(a.left, b.left) && isSame(a.right, b.right);
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
