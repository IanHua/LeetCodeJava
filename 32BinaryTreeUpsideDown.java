/**
 * 32. Binary Tree Upside Down
 * Bottom-up recursively to avoid copy parent
 * O(n)
 */
private TreeNode bottomUp(TreeNode node, TreeNode parent) {
	if (node == null) return parent;
	TreeNode root = bottomUp(node.left, node);
	node.left = (parent == null) ? parent : parent.right;
	node.right = parent;
	return root;
}
public TreeNode upsideDownBinaryTree(TreeNode root) {
	return bottomUp(root, null);
}