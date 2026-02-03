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
    //TC-O(L) and SC-O(1), L is length of head
    //create dummy and point next to head 
    //move fast to n+1 including dummy
    //move slow and fast by 1 until fast gets null
    //by then slow will be target-1
    //slow.next to slow.next.next to remove target
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);//for edge case like removing head
        //to remove head we need to stand before head to remove
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        for (int i = 0; i <= n; i++) {//0-n=n+1 including dummy
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;//one next
        }
        slow.next = slow.next.next;
        return dummy.next;//dummy.next has head
    }
}