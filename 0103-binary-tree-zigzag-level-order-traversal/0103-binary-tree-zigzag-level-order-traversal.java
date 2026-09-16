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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean leftToRight = true;

        while (!q.isEmpty()) {

            int levelSize = q.size();

            Deque<Integer> temp = new ArrayDeque<>();

            while (levelSize-- > 0) {

                TreeNode t = q.poll();

                if (leftToRight) {
                    temp.addLast(t.val);
                }
                else {
                    temp.addFirst(t.val);
                }

                if (t.left != null) {
                    q.offer(t.left);
                }

                if (t.right != null) {
                    q.offer(t.right);
                }
            }

            res.add(new ArrayList<>(temp));

            leftToRight = !leftToRight;
        }

        return res;
    }
}