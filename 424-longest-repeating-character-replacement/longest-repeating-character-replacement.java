class Solution {
    public int characterReplacement(String s, int k) {
        //TC-O(n) and SC-O(1)
        int[] count = new int[26];//Alphabets count
        int left = 0, maxFreq = 0, maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            maxFreq = Math.max(maxFreq, ++count[s.charAt(right) - 'A']);
            //Rule: length-maxFreq<=k
            while ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);//Length Position=index+1
        }
        return maxLength;
    }
}