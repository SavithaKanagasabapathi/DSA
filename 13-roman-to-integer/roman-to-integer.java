class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> numIndexMap = new HashMap<>();
        numIndexMap.put('I', 1);
        numIndexMap.put('V', 5);
        numIndexMap.put('X', 10);
        numIndexMap.put('L', 50);
        numIndexMap.put('C', 100);
        numIndexMap.put('D', 500);
        numIndexMap.put('M', 1000);

        int result = 0;
        int previousInt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int intI = numIndexMap.get(s.charAt(i));
            if (intI >= previousInt) {
                result += intI;
            } else {
                result -= intI;
            }
            previousInt = intI;
        }
        return result;
    }
}