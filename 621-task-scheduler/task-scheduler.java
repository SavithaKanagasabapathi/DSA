class Solution {
    public int leastInterval(char[] tasks, int n) {
        //TC-O(T*Log26) and SC-O(1), T is no of tasks, T times 26 letters freq added&removed in heap
        //heap operation is logn, normal queue/deque is O(1), Space is 1 as only 26 constant storage
        if (n == 0) {
            return tasks.length;//if no intervals, return length
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Deque<int[]> freqTimeQueue = new ArrayDeque<>();
        int[] freq = new int[26];
        int time = 0;
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        for (int f : freq) {
            if (f > 0) {
                maxHeap.add(f);
            }
        }
        while (!maxHeap.isEmpty() || !freqTimeQueue.isEmpty()) {//if maxHeap or freqTimeQueue any must 
            time++;//for idle, maxHeap will be empty and freqTimeQueue will have remaining freq
            if (!freqTimeQueue.isEmpty() && freqTimeQueue.peek()[1] == time) {
                maxHeap.add(freqTimeQueue.poll()[0]);
            }
            if (!maxHeap.isEmpty()) {
                int remainingFreq = maxHeap.poll() - 1;
                if (remainingFreq > 0) {
                    freqTimeQueue.add(new int[] { remainingFreq, time + n + 1 });
                }
            }
        }
        return time;

        //TC-O(N) and SC-O(1)
        // int[] freq = new int[26];
        // for (char task : tasks) {
        //     freq[task - 'A']++;
        // }
        // int maxFreq = 0, maxFreqCount = 0;
        // for (int f : freq) {
        //     maxFreq = Math.max(f, maxFreq);
        // }
        // for (int f : freq) {
        //     if (f == maxFreq) {
        //         maxFreqCount++;
        //     }
        // }
        // int ans = (maxFreq - 1) * (n + 1) + maxFreqCount;//consider A,A,A and n=2
        //complete block - (A--)(A--)A = maxFreq-1
        //block components - A-- = 1+2 = 1+n
        //maxFreqCount - Atlast lonely tasks added here A, If B also present with same maxFreq, AB 
        //return Math.max(ans, tasks.length);//if n=0, result in tasks.length 
        //but this formula returns less than tasks.length, which is wrong, so max(ans, length)
    }
}