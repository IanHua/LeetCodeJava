/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//  1
// / \
// 2  3
// preorder: 1,2,3
// inorder: 2,1,3
class Solution {
    public TreeNode buildTreeIndex(int[] preorder, int[] inorder, int startPreorder, int endPreorder, 
                                   int startInorder, int endInorder) {
        if (startPreorder >= endPreorder || startInorder >= endInorder) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[startPreorder]);
        int index = 0;
        for (int i = startInorder; i < endInorder; i++) {
            if (root.val == inorder[i]) {
                index = i;
                break;
            }
        }
        root.left = buildTreeIndex(preorder, inorder, startPreorder + 1, endPreorder, startInorder, index);
        root.right = buildTreeIndex(preorder, inorder, startPreorder + 1 + (index - startInorder), endPreorder, index + 1, endInorder);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        TreeNode root = buildTreeIndex(preorder, inorder, 0, preorder.length, 0, inorder.length);
        return root;
    }
}