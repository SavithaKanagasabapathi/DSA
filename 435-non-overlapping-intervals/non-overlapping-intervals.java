class Solution {
    //TC-O(NLOGN) and SC-O(1), for sorting
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));//sort by end time
        //As here we are checking efficient intervals like we are dealing with deadlines of assignments
        //Which one to pick based on which ends first
        int count = 0, n = intervals.length, endTime = intervals[0][1];//end of first
        for (int i = 1; i < n; i++) {
            if (endTime > intervals[i][0]) {//end>start-overlapping
                count++;
            } else {
                endTime = intervals[i][1];
            }
        }
        return count;
    }
}