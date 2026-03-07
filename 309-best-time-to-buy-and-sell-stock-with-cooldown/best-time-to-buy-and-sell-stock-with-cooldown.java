class Solution {
    public int maxProfit(int[] prices) {
        //TC-O(N) and SC-O(1)
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int hold = -prices[0], sold = 0, rest = 0;//first day holding price[0], -for buy cash outflow
        for (int i = 1; i < prices.length; i++) {//Start from day 2 that is index 1
            int prevHold = hold, prevSold = sold, prevRest = rest;//that is i-1
            hold = Math.max(prevHold, prevRest - prices[i]);
            //either we hold another day or buy (rest balance price we have-today's price)
            sold = prevHold + prices[i];
            //sell hold with today's price. hold is -ve, so +prices[i] as we sell +ve
            rest = Math.max(prevRest, prevSold);
            //either we rest another day, or previous day we sold, so cooldown, 
            //prevSold will be greater than prevRest if previous day sold
        }
        return Math.max(sold, rest);
        //max of cash inflow - either we sell or rest, max of that, 
        //hold is getting and holding so that is cash outflow
    }
}