/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int order = 1;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        int leftVal = kthSmallest(root.left, k);
        if (leftVal != -1) return leftVal;
        if (order != k) order = order + 1;
        else return root.val;
        int rightVal = kthSmallest(root.right, k);
        if (rightVal != -1) return rightVal;
        return -1;
    }
}