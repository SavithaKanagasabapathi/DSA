class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //positive_sum+negative_sum=total_sum and positive_sum-negative_sum=target, if we combine
        //2 positive_sum=total_sum+target, positive_sum=(total_sum+target)/2
        //so sum+target have to be divisible by 2, else return 0
        //if 111, all + gives 3, all - gives -3, if abs(target) is greater than target, it's impossible
        //knapsack problem, decrement from target as if you increment, u may include same num 
        //many times like coin change problem we can include as many coins there we increment, 
        //but here we need to use once, so decrement
        //similar to partition equal subset sum
        //we are making dp of i like no. of ways to make i

        //TC-O(N.T) and SC-O(T), where n is nums length, t is new target
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 != 0 || Math.abs(target) > sum) {
            return 0;
        }
        int newTarget = (sum + target) / 2;
        int[] dp = new int[newTarget + 1];
        dp[0] = 1;//1 way of making 0 is empty set
        for (int num : nums) {
            for (int i = newTarget; i >= num; i--) {
                dp[i] += dp[i - num];//no of ways to make i is include itself and i-num
            }
        }
        return dp[newTarget];
    }
}