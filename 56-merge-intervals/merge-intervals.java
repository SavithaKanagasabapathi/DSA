class Solution {
    //TC-O(nlogn) and SC-O(N), n times loop and list for result storing
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));//sort based on start time
        int[] currentInterval = intervals[0];//first interval
        result.add(currentInterval);//add here in result, 
        //it'll also get changed if you change the value later as it is pointing to address
        for (int i = 1; i < n; i++) {
            if (currentInterval[1] >= intervals[i][0]) {//end>=start
                currentInterval[0] = Math.min(intervals[i][0], currentInterval[0]);//min of start time
                currentInterval[1] = Math.max(intervals[i][1], currentInterval[1]);//max of end time
            } else {
                result.add(intervals[i]);
                currentInterval = intervals[i];//change currentInterval to intervals[i]
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}