package leetcode.trees;

import java.util.*;

public class MediumBinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

    }

    class Solution {
        Map<Integer, List<Integer>> resultMap = new HashMap<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            bfs(root, 0);
            List<List<Integer>> result = new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> entry : resultMap.entrySet()){
                result.add(entry.getValue());
                System.out.println(entry.getValue());
            }
            return result;
        }

        private void bfs(TreeNode root, int order){
            if (root == null){
                return;
            }

            bfs(root.left, order + 1);
            bfs(root.right, order + 1);

            List<Integer> list;
            if (resultMap.containsKey(order)){
                list = resultMap.get(order);
            } else {
                list = new ArrayList<>();
            }
            list.add(root.val);
            resultMap.put(order, list);
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
