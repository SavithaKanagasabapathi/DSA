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
    //find middle
    //reverse second half
    //merge both halves
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = reverse(slow.next);
        slow.next = null;//mark 3.next to null or else cycle will be formed 
        while (secondHalf != null) {
            ListNode next1 = head.next;
            ListNode next2 = secondHalf.next;

            head.next = secondHalf;//first next second 1-5
            secondHalf.next = next1;//after 5, 2 needs to come, so next1

            head = next1;//set next to current
            secondHalf = next2;
        }
    }

    private ListNode reverse(ListNode node) {
        ListNode end = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = end;
            end = node;
            node = next;
        }
        return end;
    }
}