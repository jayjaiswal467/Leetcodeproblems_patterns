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

import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> diary = new ArrayList<>();

        fun(root, targetSum, 0, diary, result);
        return result;
    }

    public void fun(TreeNode node, int targetSum, int sum,
        List<Integer> diary, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        diary.add(node.val);
        sum += node.val;

        if (node.left == null && node.right == null) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(diary));
            }
        } else {
            fun(node.left, targetSum, sum, diary, result);
            fun(node.right, targetSum, sum, diary, result);
        }

        diary.remove(diary.size() - 1);
    }
}
