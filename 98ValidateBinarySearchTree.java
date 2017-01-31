/**
 * 98. Validate Binary Search Tree
 * Build a new function for recursion
 * Set low and high bound for each node to check if it complys the definition of BST
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
    private boolean valid (TreeNode node, Integer low, Integer high) {
        if (node == null) return true;
        else {
            return (low == null || node.val > low) 
            && (high == null || node.val < high) 
            && valid(node.left, low, node.val) 
            && valid(node.right, node.val, high);
        }
    }
    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }
}