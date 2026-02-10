class Solution {
    // TC-O((V+E)logV), logV for PriorityQueue operations (insert/extract-min).
    // SC-O(V+E), O(V+E) to store the adj list and O(V) for the dist array and pq
    public int networkDelayTime(int[][] times, int n, int k) {
        Graph graph = new Graph(n + 1, true);//n+1 as nodes starting from 1
        for (int[] time : times) {
            graph.addEdges(time[0], time[1], time[2]);
        }
        int[] dist = graph.dijkstra(k);
        int max = 0;
        for (int i = 1; i <= n; i++) {//start from 1 as our nodes start from 1-n
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;//If any node not receive signal
            }
            max = Math.max(dist[i], max);//max signal delay
        }
        return max;
    }
}

class Graph {
    int n;
    boolean isDirected;
    List<List<Edge>> adjList = new ArrayList<>();

    public Graph(int n, boolean isDirected) {
        this.n = n;
        this.isDirected = isDirected;
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdges(int u, int v, int w) {
        adjList.get(u).add(new Edge(u, v, w));
        if (!isDirected) {
            adjList.get(v).add(new Edge(v, u, w));
        }
    }

    public int[] dijkstra(int start) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.w));
        pq.offer(new Edge(start, start, 0));//dummy to start
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (current.w > dist[current.v]) {
                continue;
            }
            for (Edge edge : adjList.get(current.v)) {
                if (dist[current.v] != Integer.MAX_VALUE && dist[current.v] + edge.w < dist[edge.v]) {
                    dist[edge.v] = dist[current.v] + edge.w;
                    pq.offer(new Edge(current.u, edge.v, dist[edge.v]));
                }
            }
        }
        return dist;
    }

    class Edge {
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}