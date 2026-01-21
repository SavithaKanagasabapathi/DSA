class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Using Swap
        // TC-O(nn!) and SC(n^2) as using hashset extra n times
        // List<List<Integer>> result = new ArrayList<>();
        // // No sorting required for the swap method!
        // backtrack(0, nums, result);
        // return result;

        // Using Boolean
        // TC-O(nn!) and SC(n) 
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(int start, int[] nums, List<List<Integer>> result) {
        if (start == nums.length) {
            result.add(Arrays.stream(nums).boxed().toList());
        }
        Set<Integer> appeared = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            // Skip if we already used this value for the 'start' position
            if (!appeared.add(nums[i])) {
                continue;
            }
            swap(nums, start, i);
            backtrack(start + 1, nums, result);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            // Skip if already used in current path
            if (used[i])
                continue;
            // 2. The Duplicate Check: skip if previous element is the same 
            // and hasn't been used yet (to maintain a consistent order)
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            used[i] = true;
            path.add(nums[i]);
            backtrack(res, path, nums, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}