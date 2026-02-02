/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //TC-O(M+N) and SC-O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        while (lengthA > lengthB) {
            headA = headA.next;
            lengthA--;
        }
        while (lengthB > lengthA) {
            headB = headB.next;
            lengthB--;
        }
        //checking location in  memory and not value
        while (headA != headB) {//last not equal node.next is intersection
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int getLength(ListNode node) {
        int length = 0;
        while (node.next != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}