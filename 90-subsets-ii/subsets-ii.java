class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //TC-O(n2^n) and SC-O(n2^n) - 2^n subsets doing n operations
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);//For duplicate case, sort will help
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int start) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            backtrack(result, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}