class Solution {
    //TC-O(N) and SC-O(N)
    //two-pass greedy - left-right and right-left
    //no one will ask 1 rating gets same as 2 rating, as long as 2 rules obeyed
    //same way no one will ask, if same rating children gets different candies
    public int candy(int[] ratings) {
        int n = ratings.length, result = 0;
        int[] candy = new int[n];
        Arrays.fill(candy, 1);//rule 1-every child have atleast 1 candy
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;//if rating high, they should get higher than neighbor, 
                //so neighbor+1
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
                //if candy[i] already greater than right from first loop, 
                //we need to avoid adding extra 1 candy
            }
        }
        for (int c : candy) {
            result += c;
        }
        return result;
    }
}
