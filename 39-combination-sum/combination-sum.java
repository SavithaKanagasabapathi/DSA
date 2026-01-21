class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //TC-O(n^t/m) and SC-O(t/m), n in total input size, m is min num in i/p, t is target
        //if n=4, m=2, t=10 = 4^5 recursive calls
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) {
                break;//skip all other nums also, for this step we sort the array
            }
            temp.add(nums[i]);
            backtrack(result, temp, nums, target - nums[i], i);//each time, target-current value 
            //give current index again in start to add same number many times 
            //until it breaks or added to result
            temp.remove(temp.size() - 1);
        }
    }
}