/**
 * 110. Balanced Binary Tree
 * If one subtree is unbalanced, then the parent is unbalanced
 * O(n)
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int maxDepth(TreeNode node) {
        if (node == null) return 0;
        int L = maxDepth(node.left);
        if (L == -1) return -1;
        int R = maxDepth(node.right);
        if (R == -1) return -1;
        return Math.abs(L - R) <= 1 ? Math.max(L, R) + 1 : -1;
    }
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }
}