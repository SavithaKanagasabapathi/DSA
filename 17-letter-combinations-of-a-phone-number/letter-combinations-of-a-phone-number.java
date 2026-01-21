class Solution {
    //static O(1) access
    private static final String[] LETTER_MAPPING = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        //TC-O(n4^n) and SC-O(n), for 7 and 9 - 4 digits letter, else n*3^n
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder temp, String digits, int index) {
        if (index == digits.length()) {
            result.add(temp.toString());
            return;
        }
        String letter = LETTER_MAPPING[digits.charAt(index) - '0'];
        for (char c : letter.toCharArray()) {
            temp.append(c);
            backtrack(result, temp, digits, index + 1);
            temp.setLength(temp.length() - 1);
        }
    }
}