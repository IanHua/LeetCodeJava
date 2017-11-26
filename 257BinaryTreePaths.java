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
    private void backtrack(List<String> res, String path, TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            res.add(new String(path + node.val));
            return;
        }
        if (node.left != null) backtrack(res, path + node.val + "->", node.left);
        if (node.right != null) backtrack(res, path + node.val + "->", node.right);
        return;
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        backtrack(res, "", root);
        return res;
    }
}