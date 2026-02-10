import java.util.*;

public class TopologicalSort {
    // TC-O(V + E) and SC-O(V + E)
    // to store the graph and O(V) for the stack/queue/visited arrays.

    // if an edge exists from u to v, then u must appear before v in the final list.
    // Kahn's (BFS): Always pick the "ready" nodes (those with zero incoming edges)
    // so you are guaranteed that no u is left behind before its v.

    // DFS: Go to the very end of a path (the "leaf" nodes) and work backwards,
    // ensuring that v is only recorded after everything it points to is finished,
    // then flip the result so u comes first.

    static class Graph {
        int n;
        List<List<Integer>> adj;

        public Graph(int n) {
            this.n = n;
            this.adj = new ArrayList<>();
            for (int i = 0; i < n; i++)
                adj.add(new ArrayList<>());
        }

        public void addEdge(int u, int v) {
            adj.get(u).add(v);
        }

        // 1. Kahn's Algorithm (BFS Approach)
        public void kahnTopologicalSort() {
            int[] indegree = new int[n];// incoming edges for all vertices
            for (int u = 0; u < n; u++) {
                for (int v : adj.get(u)) {
                    indegree[v]++;
                }
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (indegree[i] == 0) {
                    queue.add(i);
                }
            }
            List<Integer> result = new ArrayList<>();
            while (!queue.isEmpty()) {
                int u = queue.poll();
                result.add(u);
                for (int v : adj.get(u)) {
                    indegree[v]--;
                    if (indegree[v] == 0) {
                        queue.add(v);
                    }
                }
            }
            if (result.size() != n) {// nodes will ever have an indegree of 0,
                // if they are cyclic, it will be less than n
                System.out.println("Kahn's BFS: Cycle detected! No valid topological sort.");
            } else {
                System.out.println("Kahn's BFS Sort: " + result);
            }
        }

        // 2. DFS-Based Approach
        public void dfsTopologicalSort() {
            Stack<Integer> stack = new Stack<>();
            int[] visited = new int[n]; // 0: unvisited, 1: visiting, 2: visited
            boolean hasCycle = false;
            for (int i = 0; i < n; i++) {
                if (visited[i] == 0) {
                    if (isCyclicDFS(i, visited, stack)) {
                        hasCycle = true;
                        break;
                    }
                }
            }
            if (hasCycle) {
                System.out.println("DFS: Cycle detected! No valid topological sort.");
            } else {
                List<Integer> result = new ArrayList<>();
                while (!stack.isEmpty()) {
                    result.add(stack.pop());
                }
                System.out.println("DFS Sort: " + result);
            }
        }

        private boolean isCyclicDFS(int u, int[] visited, Stack<Integer> stack) {
            visited[u] = 1; // Mark as 'Visiting'
            for (int v : adj.get(u)) {
                if (visited[v] == 1) {
                    return true; // Found a back edge (cycle)
                }
                if (visited[v] == 0 && isCyclicDFS(v, visited, stack)) {
                    return true;
                }
            }
            visited[u] = 2; // Mark as 'Fully Visited'
            stack.push(u); // Post-order: add to stack after visiting all neighbors
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Case 1: Valid DAG");
        Graph dag = new Graph(6);
        dag.addEdge(5, 2);
        dag.addEdge(5, 0);
        dag.addEdge(4, 0);
        dag.addEdge(4, 1);
        dag.addEdge(2, 3);
        dag.addEdge(3, 1);
        dag.kahnTopologicalSort();
        dag.dfsTopologicalSort();

        System.out.println("\nCase 2: Graph with Cycle");
        Graph cyclic = new Graph(3);
        cyclic.addEdge(0, 1);
        cyclic.addEdge(1, 2);
        cyclic.addEdge(2, 0); // Cycle back to start
        cyclic.kahnTopologicalSort();
        cyclic.dfsTopologicalSort();
    }
}