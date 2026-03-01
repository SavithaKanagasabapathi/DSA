class Solution {
    public boolean canPartition(int[] nums) {
        //partition to eaqual 2 halves, so sum/2 is target, sum=subset1+subset2
        //if any subset reaches target, other subset also will achieve target
        //if subset2 is sum/2, sum=subset1+sum/2, subset1=sum-sum/2=>2sum-sum/2=>sum/2
        //as we are dividing equal 2 half, odd sum is false as target will be decimal, 
        //we don't have decimals to equal
        //knapsack problem, decrement from target as if you increment, u may include same num 
        //many times like coin change problem we can include as many coins there we increment, 
        //but here we need to use once, so decrement

        //TC-O(N.T) and SC-O(T), where n is nums length, t is target
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];//dp of i is can we make target with i
        dp[0] = true;//dp[0] is true as we can make target from 0, by without keeping anthing
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                if (dp[i - num]) {//to find target dp, if target-num is true, it's true
                    dp[i] = true;
                }
            }
            if (dp[target]) {//Optimisation, if any time dp[target] true, can return true
                return true;
            }
        }
        return dp[target];
    }
}