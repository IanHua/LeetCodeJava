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
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean right = true;
        while (!queue.isEmpty()) {
            int numNextLevel = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < numNextLevel; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (right) {
                ans.add(level);
            } else {
                Collections.reverse(level);
                ans.add(level);
            }
            right = !right;
        }
        return ans;
    }
}