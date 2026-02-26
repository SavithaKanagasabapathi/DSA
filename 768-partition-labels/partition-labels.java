class Solution {
    public List<Integer> partitionLabels(String s) {
        //TC-O(N) and SC-O(1)
        //if any char seen that should be in 1 partition
        //store char last index and partition and return length array
        int[] lastIndex = new int[26];
        List<Integer> result = new ArrayList<>();
        int n = s.length(), start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;//last index of char
        }
        for (int i = 0; i < n; i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            //max of (end of another char present before in partition, current char last index)
            if (i == end) {
                result.add(end - start + 1);//length of partition
                start = i + 1;//next char
            }
        }
        return result;
    }
}