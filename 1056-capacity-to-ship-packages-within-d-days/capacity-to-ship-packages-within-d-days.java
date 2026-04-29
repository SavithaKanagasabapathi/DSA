class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //TC-O(n.log(E(weights)-max(weights))) and SC-O(1), n for loop and log of n, n is sum(w)-max(w)
        int left = 0, right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);//left is max(weights)
            right += weight;//right is sum(weights)
        }
        while (left < right) {
            int mid = left + (right - left) / 2;//capacity
            if (canShip(weights, days, mid)) {
                right = mid;//this itself satisfies but we can go further and check min capacity
            } else {
                left = mid + 1;//increase capacity as can't able to ship within days
            }
        }
        return left;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int currentDays = 1, currentWeight = 0;
        for (int weight : weights) {
            if (currentWeight + weight > capacity) {
                currentWeight = 0;
                currentDays++;
            }
            currentWeight += weight;
        }
        return currentDays <= days;
    }

    //1,2,3,4,5,6,7,8,9,10
    //10--55
    //mid is 32, 1 to 7 and 8 to 10 - 2 days<=5 days 
    //so moving further min
    //10--32, mid is 21, 1 to 6, 7 to 8, 9 to 10 - 3 days<=5 days
    //so moving further min
    //10--21, mid is 15, 1 to 5, 6 to 7, 8, 9, 10 - 5 days = 5 days
    //so moving further min
    //10--15, mid is 12, 1 to 4, 5 to 6, 7, 8, 9, 10 - 6 days X
    //So return old left 15

}