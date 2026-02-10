import java.util.*;

public class Algorithms {

    static class Edge {
        int u, v, weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    static class Graph {
        int n;
        boolean isDirected;
        List<List<Edge>> adj;
        List<Edge> allEdges; // For Bellman-Ford, no need to create adj list, it also works with adj list

        public Graph(int n, boolean isDirected) {
            this.n = n;
            this.isDirected = isDirected;
            this.adj = new ArrayList<>();
            this.allEdges = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v, int weight) {
            adj.get(u).add(new Edge(u, v, weight));
            allEdges.add(new Edge(u, v, weight));
            if (!isDirected) {
                adj.get(v).add(new Edge(v, u, weight));
                // We don't add to allEdges here to avoid double-processing in Bellman-Ford
            }
        }

        // 1. Dijkstra (Shortest Path - Greedy)
        // TC-O((V+E)logV), logV for PriorityQueue operations (insert/extract-min).
        // SC-O(V+E), O(V+E) to store the adj list and O(V) for the dist array and pq
        public void dijkstra(int start) {
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[start] = 0;

            PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

            // We create a "dummy" edge representing the starting point (dist 0)
            pq.offer(new Edge(start, start, 0));

            while (!pq.isEmpty()) {
                Edge curr = pq.poll();
                int u = curr.v; // The node we are visiting
                int d = curr.weight; // The distance to this node

                if (d > dist[u]) {// pq may contain outdated entries, we skip them,
                    // like if we already found a shorter path to u, we ignore this one
                    continue;
                }

                for (Edge edge : adj.get(u)) {
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + edge.weight < dist[edge.v]) {
                        dist[edge.v] = dist[u] + edge.weight;
                        // We create a new Edge object to put in the PQ
                        // v is the neighbor, weight is the NEW total distance
                        pq.offer(new Edge(u, edge.v, dist[edge.v]));
                    }
                }
            }
            System.out.println("Dijkstra Distances: " + Arrays.toString(dist));
        }

        // 2. Bellman-Ford (Shortest Path - Dynamic Programming)
        // TC-O(V×E), relaxing every edge in the graph (E) for a total of V−1 iterations
        // SC-O(V+E), O(V+E) for the adj list and O(V) for the distance array.
        public void bellmanFord(int start) {
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[start] = 0;

            for (int i = 0; i < n - 1; i++) {// n-1 times to relax all edges
                for (Edge edge : allEdges) {
                    if (dist[edge.u] != Integer.MAX_VALUE && dist[edge.u] + edge.weight < dist[edge.v]) {
                        dist[edge.v] = dist[edge.u] + edge.weight;
                    }
                }
            }
            for (Edge edge : allEdges) {
                if (dist[edge.u] != Integer.MAX_VALUE && dist[edge.u] + edge.weight < dist[edge.v]) {
                    System.out.println("Graph contains a negative weight cycle!");
                    return; // Shortest path is undefined
                }
            }
            System.out.println("Bellman-Ford Distances using allEdges: " + Arrays.toString(dist));

            // for (int i = 0; i < n - 1; i++) {
            // // Iterate through every node and every neighbor (total E edges)
            // for (int u = 0; u < n; u++) {
            // for (Edge e : adj.get(u)) {
            // if (dist[u] != Integer.MAX_VALUE && dist[u] + e.weight < dist[e.v]) {
            // dist[e.v] = dist[u] + e.weight;
            // }
            // }
            // }
            // }
            // System.out.println("Bellman-Ford Distances using adj list: " +
            // Arrays.toString(dist));
        }

        // 3. Prim's Algorithm (Minimum Spanning Tree)
        // TC-O(ElogV), logV for PriorityQueue operations (insert/extract-min).
        // SC-O(V+E), O(V+E) for the adj list and O(V) for the boolean array and pq
        public void primMST() {
            boolean[] visited = new boolean[n];
            PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

            // Start from imaginary edge to node 0 with weight 0
            pq.offer(new Edge(-1, 0, 0));
            int totalWeight = 0;
            int count = 0;

            while (!pq.isEmpty()) {
                Edge curr = pq.poll();
                if (!visited[curr.v]) {
                    visited[curr.v] = true;
                    totalWeight += curr.weight;
                    count++;
                    for (Edge neighbor : adj.get(curr.v)) {
                        if (!visited[neighbor.v])
                            pq.offer(neighbor);
                    }
                }
            }
            if (count == n)
                System.out.println("Prim's MST Total Weight: " + totalWeight);
            else
                System.out.println("Prim's: MST not possible (Graph disconnected)");
        }
    }

    public static void main(String[] args) {
        // Standard Directed Graph (Non-Negative)
        Graph graph = new Graph(5, true);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 3);
        graph.addEdge(2, 1, 1);
        graph.addEdge(2, 4, 5);
        graph.addEdge(4, 3, 1);
        graph.dijkstra(0);
        graph.bellmanFord(0);

        // Negative Directed Graph Safe and no negative cycles
        Graph graph1 = new Graph(3, true);
        graph1.addEdge(0, 1, 5);
        graph1.addEdge(1, 2, -10);
        graph1.addEdge(0, 2, 2);
        graph1.bellmanFord(0);
        // Note: Dijkstra would likely give 2 for node 2,
        // but Bellman-Ford correctly finds -5

        // Negative Directed Graph with negative cycle
        Graph graph2 = new Graph(3, true);
        graph2.addEdge(0, 1, 1);
        graph2.addEdge(1, 2, 1);
        graph2.addEdge(2, 0, -5);
        graph2.bellmanFord(0);

        // Prim usually works on undirected graphs
        Graph graph3 = new Graph(5, false);
        graph3.addEdge(0, 1, 4);
        graph3.addEdge(0, 2, 2);
        graph3.addEdge(1, 2, 3);
        graph3.addEdge(1, 3, 2);
        graph3.addEdge(3, 4, 1);
        graph3.primMST();// no need to specify start node for Prim's,
        // it will find MST for the whole graph
    }
}
