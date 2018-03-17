/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy, next = dummy.next, beforeNine = dummy;
        boolean endWithNine = false;
        while (next != null) {
            if (!endWithNine && next.val == 9) {
                endWithNine = true;
                beforeNine = curr;
            } else if (next.val != 9) {
                endWithNine = false;
            }
            curr = next;
            next = next.next;
        }
        if (!endWithNine) curr.val += 1;
        else {
            beforeNine.val += 1;
            while (beforeNine.next != null) {
                beforeNine.next.val = 0;
                beforeNine = beforeNine.next;
            }
        }
        return dummy.val == 0 ? dummy.next : dummy;     
    }
}