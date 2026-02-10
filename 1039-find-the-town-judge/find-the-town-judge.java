class Solution {
    //TC-O(E+N) and SC-O(N)
    //u,v here u is trusting v, u->v, u outdegree, v indegree
    //judge = no outdegree and n-1 indegree 
    public int findJudge(int n, int[][] trust) {
        int[] trustScore = new int[n + 1];
        for (int[] pair : trust) {
            trustScore[pair[0]]--;//if judge itself trusting someone reduce
            //so final score will not be n-1
            trustScore[pair[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (trustScore[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}