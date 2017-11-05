/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        if (root == null) return;
        queue.add(root);
        while(!queue.isEmpty()) {
            int numNextLevel = queue.size();
            for (int i = 0; i < numNextLevel; i++) {
                TreeLinkNode node = queue.poll();
                if (i == numNextLevel - 1) {
                    node.next = null;
                } else {
                    TreeLinkNode nextNode = queue.peek();
                    node.next = nextNode;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return;
    }
}