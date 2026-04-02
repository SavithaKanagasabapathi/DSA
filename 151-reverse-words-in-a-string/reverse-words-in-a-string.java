class Solution {
    public String reverseWords(String s) {
        //TC-O(N) and SC-O(N)

        List<String> splittedStrings = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(splittedStrings);
        return String.join(" ", splittedStrings);

        // return Arrays.stream(s.trim().split("\\s+"))
        //      .collect(LinkedList<String>::new, LinkedList::addFirst, (a, b) -> a.addAll(0, b))
        //      .stream()
        //      .collect(Collectors.joining(" "));

        //regex for space - \\s, for one or more space - \\s+
        //String.join will add space only between words and not lead and trail space

        //186 Reverse Words in a String II - Locked
        //Same problem with single space in btw and no lead and trail space
        //Twist is inplace with no extra space

        //TC-O(N) and SC-O(1)
        //i/p be char[] for this code
        // String[] ssArray = s.trim().split("\\s+");
        // char[] ss = String.join(" ", ssArray).toCharArray();

        // reverse(ss, 0, ss.length - 1);
        // int start = 0;
        // for (int i = 0; i < ss.length; i++) {
        //     if (ss[i] == ' ') {
        //         int end = i - 1;
        //         reverse(ss, start, end);
        //         start = i + 1;
        //     }
        // }
        // reverse(ss, start, ss.length - 1);//last string won't have space
        // return new String(ss);
    }

    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
}