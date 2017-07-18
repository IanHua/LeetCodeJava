/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    bool isPalindrome(ListNode* head) {
        vector<int> nums;
        ListNode *node = head;
        while (node != NULL) {
            nums.push_back(node->val);
            node = node->next;
        }
        int len = nums.size();
        for (int i = 0; i < len / 2; i++) {
            if (nums[i] != nums[len-1-i]) {
                return false;
            }
        }
        return true;
    }
};