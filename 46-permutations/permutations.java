class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //TC-O(nn!) and SC-O(n), n! permutations, copying result O(n)
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, int start) {
        if (start == nums.length) {
            result.add(Arrays.stream(nums).boxed().toList());//nums is int[], need to box to Integer
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            backtrack(result, nums, start + 1);//swap every i with start 0-n-1, if n, add to result
            swap(nums, i, start);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}