/**
 * 124. Binary Tree Maximum Path Sum
 * O(n)
 * findMax finds max path sum for each side
 * maxSum connects both sides and maintains the sum
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int maxSum;
    private int findMax(TreeNode node) {
        if (node == null) return 0;
        int left = findMax(node.left);
        int right = findMax(node.right);
        maxSum = Math.max(node.val + left + right, maxSum);
        int ret = node.val + Math.max(left, right);
        return ret > 0 ? ret : 0;
    }
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMax(root);
        return maxSum;
    }
}