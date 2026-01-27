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
    public ListNode mergeKLists(ListNode[] lists) {
        //TC-O(Nlogk) and SC-O(K), only storing k elements(k-lists size)
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        //instead of int, ListNode given so add comparator logic
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);//add k lists head
            }
        }
        ListNode dummy = new ListNode();//head
        ListNode current = dummy;
        while (!minHeap.isEmpty()) {
            ListNode shortestNode = minHeap.poll();
            current.next = shortestNode;
            current = current.next;
            if (shortestNode.next != null) {
                minHeap.offer(shortestNode.next);//get next num from shortest first num list
            }
        }
        return dummy.next;
    }
}