import java.util.*;

public class NumberOfComponents {
    // TC-O(E.alpha(V)), where alpha is the Inverse Ackermann function.
    // In practical terms, this is constant time per edge.
    // SC-O(V) to store the parent array
    // Create parent disjoint and have components as n
    // for each edge, merge them and reduce component, return component
    // BFS, DFS both have TC-O(V+E) and SC-O(V)
    public int countComponents(int n, int[][] edges) {
        int components = n;// set n
        int[] parent = new int[n];// store each num's root
        for (int i = 0; i < n; i++) {
            parent[i] = i;// set root as themselves
        }
        for (int[] edge : edges) {
            int rootA = findRoot(parent, edge[0]);
            int rootB = findRoot(parent, edge[1]);
            if (rootA != rootB) {// if not same root
                components--;
                parent[rootA] = rootB;// merge them to same set
            }
        }
        return components;
    }

    private int findRoot(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        parent[node] = findRoot(parent, parent[node]);
        // if parent of 3 is 2, findRoot of 2 and set that root to 3 also
        // It's path compression, so that no need to traverse everytime to root
        return parent[node];
    }

    public static void main(String[] args) {
        NumberOfComponents solution = new NumberOfComponents();

        // Case 1: Standard Connected Components
        // 0-1-2, 3-4
        int n1 = 5;
        int[][] edges1 = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
        System.out.println("Test Case 1 (Expected: 2): " + solution.countComponents(n1, edges1));

        // Case 2: One big component
        // 0-1-2-3-4
        int n2 = 5;
        int[][] edges2 = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 } };
        System.out.println("Test Case 2 (Expected: 1): " + solution.countComponents(n2, edges2));

        // Case 3: No edges (Every node is its own component)
        int n3 = 5;
        int[][] edges3 = {};
        System.out.println("Test Case 3 (Expected: 5): " + solution.countComponents(n3, edges3));

        // Case 4: Disconnected nodes and a triangle
        // 0-1-2-0 (triangle), 3 (alone), 4 (alone)
        int n4 = 5;
        int[][] edges4 = { { 0, 1 }, { 1, 2 }, { 2, 0 } };
        System.out.println("Test Case 4 (Expected: 3): " + solution.countComponents(n4, edges4));
    }
}
