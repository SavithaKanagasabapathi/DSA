class Solution {
    public int lastStoneWeight(int[] stones) {
        //TC-O(NLOGN) and SC-O(N), n times adding and removing log n
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if (y != x) {
                maxHeap.offer(y - x);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}