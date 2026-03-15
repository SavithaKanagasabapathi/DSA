class Solution {
    public int minCostConnectPoints(int[][] points) {
        //TC-O(N^2) and SC-O(N)
        //Optimized Prim's 
        //Minimum Spanning Tree
        int n = points.length, mstTotal = 0, edgesCovered = 0;
        int[] minMst = new int[n];
        boolean[] edgeChecked = new boolean[n];
        for (int i = 1; i < n; i++) {//except first point
            minMst[i] = Integer.MAX_VALUE;
        }
        while (edgesCovered < n) {
            int currentPoint = -1, currentMst = Integer.MAX_VALUE;//set to default for every edge
            for (int i = 0; i < n; i++) {//loop upto min dist from current point, except first point
                if (!edgeChecked[i] && minMst[i] < currentMst) {
                    currentMst = minMst[i];
                    currentPoint = i;
                }
            }
            mstTotal += currentMst;
            edgesCovered++;
            edgeChecked[currentPoint] = true;
            for (int next = 0; next < n; next++) {//get dist from current point to all points
                if (!edgeChecked[next]) {
                    int dist = Math.abs(points[currentPoint][0] - points[next][0])
                            + Math.abs(points[currentPoint][1] - points[next][1]);//(x-x)+(y-y)
                    if (dist < minMst[next]) {
                        minMst[next] = dist;
                    }
                }
            }
        }
        return mstTotal;
    }
}