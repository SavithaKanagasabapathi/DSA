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
    //TC-O(N) and SC-O(1), only 2 pointers for any n size
    public boolean hasCycle(ListNode head) {
        //Floyd’s Tortoise and Hare Algorithm - Fast 2 steps, Slow 1 step
        if (head == null) {
            return false;
        }
        ListNode slow = head, fast = head;//both start at head
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;//1 step
            fast = fast.next.next;//2 steps
            if (slow == fast) {//if any point, they are same - it is cyclic
                return true;
            }
        }
        return false;//If fast is null, then it is normal straight list
    }
}