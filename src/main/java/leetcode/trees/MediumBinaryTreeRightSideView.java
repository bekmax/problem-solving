package leetcode.trees;

import java.util.*;

public class MediumBinaryTreeRightSideView {
    public static void main(String[] args) {

    }

    class Solution {
        Map<Integer, Stack<Integer>> resultMap = new HashMap<>();

        public List<Integer> rightSideView(TreeNode root) {
            bfs(root, 0);
            List<Integer> result = new ArrayList<>();
            for (Map.Entry<Integer, Stack<Integer>> entry : resultMap.entrySet()){
                result.add(entry.getValue().peek());
            }
            return result;
        }

        private void bfs(TreeNode root, int order){
            if (root == null){
                return;
            }

            bfs(root.left, order+1);
            bfs(root.right, order+1);

            Stack<Integer> stack;
            if (resultMap.containsKey(order)){
                stack = resultMap.get(order);
            } else {
                stack = new Stack<>();
            }
            stack.push(root.val);
            resultMap.put(order, stack);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
