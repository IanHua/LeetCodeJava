/**
 * 114. Flatten Binary Tree to Linked List
 * DFS with post-order (right first) to produce pre-order
 * O(n)
 */
class Solution {
public:
    void flatten(TreeNode* root) {
        if (root == NULL) return;
        flatten(root->right);
        flatten(root->left);
        root->right = prev;
        root->left = NULL;
        prev = root;
    }
private:
    TreeNode *prev = NULL;
};