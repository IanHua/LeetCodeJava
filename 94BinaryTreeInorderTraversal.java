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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        if (root.left != null) {
            List<Integer> left = inorderTraversal(root.left);
            ans.addAll(left);
        }
        ans.add(root.val);
        if (root.right != null) {
            List<Integer> right = inorderTraversal(root.right);
            ans.addAll(right);
        }
        return ans;
    }
}