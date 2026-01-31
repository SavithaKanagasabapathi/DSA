class Solution {
    //TC-O(N) and SC-O(N), n times loop and list for result storing
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0, n = intervals.length;
        List<int[]> result = new ArrayList<>();
        //add first small non overlapping intervals
        while (i < n && intervals[i][1] < newInterval[0]) {//end<start
            result.add(intervals[i]);
            i++;
        }
        //overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {//start<=end (reverse of above condn)
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);//min of start time
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);//max of end time
            i++;
        }
        result.add(newInterval);//add outside the loop as newIntervals merge with other overlappings
        //add other larger non overlapping intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][2]);
    }
}