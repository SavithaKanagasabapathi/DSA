import java.util.*;

public class StringCodec {

    // Encodes a list of strings to a single string.
    // Strategy: [length] + [#] + [string content]
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    // Decodes a single string back to a list of strings.
    public List<String> decode(String s) {
        int i = 0;
        List<String> result = new ArrayList<>();
        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(s.substring(i, j));
            result.add(s.substring(j + 1, j + 1 + length));
            i = j + 1 + length;
        }
        return result;
    }

    public static void main(String[] args) {
        // TC-O(N) and SC-O(N), N-no. of char in String
        StringCodec codec = new StringCodec();

        List<String> input1 = Arrays.asList("hello", "world");
        String encoded1 = codec.encode(input1);
        List<String> decoded1 = codec.decode(encoded1);
        System.out.println("Original: " + input1);
        System.out.println("Encoded : " + encoded1);
        System.out.println("Decoded : " + decoded1);

        List<String> input2 = Arrays.asList("6#apples", "!!!", " ", "4#2#1");
        String encoded2 = codec.encode(input2);
        List<String> decoded2 = codec.decode(encoded2);
        System.out.println("Original: " + input2);
        System.out.println("Encoded : " + encoded2);
        System.out.println("Decoded : " + decoded2);
    }
}