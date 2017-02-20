/**
 * 141. Linked List Cycle
 * Use HashSet to store visited ListNode
 * O(n)
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        Set<ListNode> set = new HashSet<ListNode>();
        ListNode curr = head;
        while (curr.next != null) {
            set.add(curr);
            if (set.contains(curr.next)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
}