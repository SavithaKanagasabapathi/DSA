/**
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
    //TC-O(N) and SC-O(1) - //Floyd’s Tortoise and Hare Algorithm - Fast 2 steps, Slow 1 step
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;//one step
            fast = fast.next.next;//two steps
            if (slow == fast) {//if cycle
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;//one step here
                }
                return slow;//cycle start index
            }
        }
        return null;//if no cycle
    }
}