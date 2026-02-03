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
    //TC-O(N) and SC-O(1)
    //Find middle element
    //Reverse second half
    //Check first half and second half same
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;//middle element
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = reverse(slow.next);//reverse
        while (secondHalf != null) {//check first and second half
            if (head.val != secondHalf.val) {
                return false;
            }
            head = head.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode end = null;
        ListNode current = node;
        while (current != null) {
            ListNode temp = current.next;
            current.next = end;
            end = current;
            current = temp;
        }
        return end;
    }
}