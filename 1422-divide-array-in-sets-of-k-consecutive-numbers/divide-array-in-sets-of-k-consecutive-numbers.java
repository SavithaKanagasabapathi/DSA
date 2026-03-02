class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        //TC-O(NlogN+N*k) and SC-O(N), NLOGN for treemap operations, treemap will sort it's keys
        //we need to sort keys to get nums consecutively, so used treemap
        if (nums.length % k != 0) {//if length not mulptiple of k, return false
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);//create map with num and freq
        }
        for (int num : map.keySet()) {
            int count = map.get(num);
            if (count > 0) {
                for (int i = 0; i < k; i++) {
                    int currentNum = num + i;//as it's consecutive, num+0, num+1, num+2
                    if (map.getOrDefault(currentNum, 0) < count) {
                        return false;//if next num has less freq than first, return false
                    }
                    map.put(currentNum, map.get(currentNum) - count);//reduce its freq
                }
            }
        }
        return true;

        //Hashmap - need to sort keys 
        //TC-O(NlogN+N*k) and SC-O(N), NLOGN for key sort
        // if (nums.length % k != 0) {//if length not mulptiple of grp, return false
        //     return false;
        // }
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int num : nums) {
        //     map.put(num, map.getOrDefault(num, 0) + 1);//create map with num and freq
        // }
        // int[] keys = new int[map.size()];
        // int index = 0;
        // for (int key : map.keySet()) {
        //     keys[index++] = key;
        // }
        // Arrays.sort(keys);
        // for (int num : keys) {
        //     int count = map.get(num);
        //     if (count > 0) {
        //         for (int i = 0; i < k; i++) {
        //             int currentNum = num + i;//as it's consecutive, num+0, num+1, num+2
        //             if (map.getOrDefault(currentNum, 0) < count) {
        //                 return false;//if next num has less freq than first, return false
        //             }
        //             map.put(currentNum, map.get(currentNum) - count);//reduce its freq
        //         }
        //     }
        // }
        // return true;
    }
}