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
    //TC-O(max(n,m)) and SC-O(max(n,m)), where n and m are l1 and l2 length
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carryOver = 0;
        while (l1 != null || l2 != null || carryOver != 0) {
            //sum=l1+l2+carryOver
            int sum = carryOver;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carryOver = sum / 10;//tens place
            current.next = new ListNode(sum % 10);//ones place
            current = current.next;

        }
        return dummy.next;
    }
}