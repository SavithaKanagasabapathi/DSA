import java.util.*;

public class Traversals {
    // Time Complexity: O(V + E), where V is vertices and E is edges.
    // Space Complexity: O(V), used by the visited array and the deque.

    // Simple inner class to represent the Graph
    static class Graph {
        private final int vertices;
        private final List<List<Integer>> adj;

        public Graph(int vertices) {
            this.vertices = vertices;
            this.adj = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                adj.add(new ArrayList<>());
            }
        }

        // Add edge (Directed)
        public void addEdge(int source, int destination) {
            adj.get(source).add(destination);
        }

        // --- ITERATIVE BFS QUEUE POLL ---
        public void bfs(int startNode) {
            System.out.print("BFS Iterative: ");
            boolean[] visited = new boolean[vertices];
            Queue<Integer> queue = new ArrayDeque<>();

            queue.offer(startNode);

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                if (!visited[curr]) {
                    visited[curr] = true;
                    System.out.print(curr + " ");

                    for (int neighbor : adj.get(curr)) {
                        if (!visited[neighbor]) {
                            queue.offer(neighbor);
                        }
                    }
                }
            }
            System.out.println();
        }

        // --- ITERATIVE DFS STACK POP ---
        public void dfsIterative(int startNode) {
            System.out.print("DFS Iterative: ");
            boolean[] visited = new boolean[vertices];
            Deque<Integer> stack = new ArrayDeque<>();

            stack.push(startNode);

            while (!stack.isEmpty()) {
                int curr = stack.pop();
                if (!visited[curr]) {
                    visited[curr] = true;
                    System.out.print(curr + " ");

                    // To match recursive order exactly, you'd visit neighbors in reverse
                    List<Integer> neighbors = adj.get(curr);
                    for (int i = neighbors.size() - 1; i >= 0; i--) {
                        int neighbor = neighbors.get(i);
                        if (!visited[neighbor]) {
                            stack.push(neighbor);
                        }
                    }
                }
            }
            System.out.println();
        }

        // --- RECURSIVE DFS ---
        public void dfsRecursive(int startNode) {
            System.out.print("DFS Recursive: ");
            boolean[] visited = new boolean[vertices];
            dfsHelper(startNode, visited);
            System.out.println();
        }

        private void dfsHelper(int curr, boolean[] visited) {
            visited[curr] = true;
            System.out.print(curr + " ");
            for (int neighbor : adj.get(curr)) {
                if (!visited[neighbor]) {
                    dfsHelper(neighbor, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Create a graph with 6 nodes (0 to 5)
        Graph graph = new Graph(6);

        // Define edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        graph.bfs(0);
        graph.dfsIterative(0);
        graph.dfsRecursive(0);
    }
}
