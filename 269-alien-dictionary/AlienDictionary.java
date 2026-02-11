import java.util.*;

public class AlienDictionary {
    // TC-O(N + M) where N is the number of words and M is the total number of
    // characters in all words
    // SC-O(N + M) for the adjacency list and visited map
    // Build adj and visited maps and not list as these are chars and not numbers.
    // Build graph, if apple, app given they should be in order - app, apple
    // and if not then return empty string.
    // Usually how we will arrange in order is by comparing two words and finding
    // the first different character.
    // dfs and topological sort to find the order of characters.
    // If we find a cycle then return empty string.

    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> visited = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        // build adj and visited maps
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                adj.putIfAbsent(c, new ArrayList<>());
                visited.putIfAbsent(c, 0);// 0-unvisited, 1-visiting, 2-visited
            }
        }
        for (int i = 0; i < words.length - 1; i++) {// compare 2 words
            if (words[i].length() > words[i + 1].length() && words[i].startsWith(words[i + 1])) {// apple, app - ""
                return "";
            }
            for (int j = 0; j < Math.min(words[i].length(), words[i + 1].length()); j++) {// min of 2 words length
                char a = words[i].charAt(j), b = words[i + 1].charAt(j);
                if (a != b) {
                    adj.get(a).add(b);// construct adj tree list
                    break;// only first different character matters
                }
            }
        }
        for (char c : visited.keySet()) {
            if (visited.get(c) == 0) {
                if (hasCycle(c, visited, adj, sb)) {
                    return "";
                }
            }
        }
        return sb.reverse().toString();// reverse to get topological order
    }

    private boolean hasCycle(char c, Map<Character, Integer> visited, Map<Character, List<Character>> adj,
            StringBuilder sb) {
        if (visited.get(c) == 1) {
            return true;
        }
        if (visited.get(c) == 0) {
            visited.put(c, 1);
            for (char neighbor : adj.get(c)) {
                if (hasCycle(neighbor, visited, adj, sb)) {
                    return true;
                }
            }
            visited.put(c, 2);
            sb.append(c);
        }
        return false;
    }

    public static void main(String[] args) {
        AlienDictionary solution = new AlienDictionary();

        // Test Case 1: Standard Order
        String[] words1 = { "wrt", "wrf", "er", "ett", "rftt" };
        System.out.println("Test Case 1 (Expected: wertf): " + solution.alienOrder(words1));

        // Test Case 2: Cycle Detection
        String[] words2 = { "z", "x", "z" };
        System.out.println("Test Case 2 (Expected: \"\"): " + solution.alienOrder(words2));

        // Test Case 3: Simple Sorted
        String[] words3 = { "z", "x" };
        System.out.println("Test Case 3 (Expected: zx): " + solution.alienOrder(words3));
    }
}