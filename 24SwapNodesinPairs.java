/**
 * 24. Swap Nodes in Pairs
 * curr, next, next's next
 * We need dummyHead because it can avoid special handling, also use the same while loop
 * O(n)
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        ListNode p, q, r, prev;
        prev = dummyHead;
        dummyHead.next = head;
        p = head;
        while (p != null && p.next != null) {
            q = p.next;
            r = q.next;
            prev.next = q;
            q.next = p;
            p.next = r;
            prev = p;
            p = r;
        }
        return dummyHead.next;
    }
}