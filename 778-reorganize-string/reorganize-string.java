class Solution {
    public String reorganizeString(String s) {
        //TC-O(nlogk) and SC-O(k), k is 26
        //if any char occurs >n/2 times, it's impossible for putting in 0,2,4 even places
        //if n is odd, if we divide in decimal some place will go, so +1
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;//count freq
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);//max heap
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                if (count[i] > ((s.length() + 1) / 2)) {
                    return "";
                }
                pq.offer(new int[] { i + 'a', count[i] });//char, count
            }
        }
        StringBuilder sb = new StringBuilder();
        int[] prev = new int[2];
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            sb.append((char) curr[0]);//most occuring
            curr[1]--;
            if (prev != null && prev[1] > 0) {//store the prev as we no need to add in pq
                pq.offer(prev);
            }
            prev = curr;
        }
        return sb.toString();
    }
}