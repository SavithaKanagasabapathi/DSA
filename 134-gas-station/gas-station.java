class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //TC-O(N) and SC-O(1)
        //if gas[i]>=cost[i], then only we can travel
        int n = gas.length, totalGas = 0, totalCost = 0, start = 0, currentTank = 0;
        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentTank += gas[i] - cost[i];
            if (currentTank < 0) {
                start = i + 1;
                currentTank = 0;
            }
        }
        return totalGas < totalCost ? -1 : start;//for ideal case, totalGas>=totalCost
    }
}