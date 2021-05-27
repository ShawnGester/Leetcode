/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // idea: add digit by digit right to left (left to right in actuality), keep carry values
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode curr = new ListNode(0);
        ListNode head = curr;
        int carry = 0;
        while (curr1 != null || curr2 != null || carry != 0) {
            if (curr1 == null && curr2 != null && carry == 0) {
                curr.next = curr2;
                break;
            }
            if (curr2 == null && curr1 != null && carry == 0) {
                curr.next = curr1;
                break;
            }
            int val = carry;
            val += curr1 == null ? 0 : curr1.val;
            val += curr2 == null ? 0 : curr2.val;
            carry = val / 10;
            val = val > 9 ? val - 10 : val;
            curr.next = new ListNode(val);
            curr = curr.next;
            curr1 = curr1 == null ? null : curr1.next;
            curr2 = curr2 == null ? null : curr2.next;
        }
        return head.next;
    }
}
