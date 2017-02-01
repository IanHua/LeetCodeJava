/**
 * 111. Minimum Depth of Binary Tree
 * Similar to maximum depth
 * Notice the minimum depth of tree with one empty subtree depends on the other subtree
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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);
    }
}