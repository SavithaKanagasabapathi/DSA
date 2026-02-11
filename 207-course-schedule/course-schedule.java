class Solution {
    //TC-O(V+E) and SC-O(V+E), due to recursion stack
    //Topological Sorting, if cycle present, all are dependents so return false
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] visited = new int[numCourses];//0-unvisited, 1-visiting, 2- visited
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] course : prerequisites) {//u,v - v first and u second, so v->u
            adjList.get(course[1]).add(course[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (hasCycle(visited, adjList, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasCycle(int[] visited, List<List<Integer>> adjList, int course) {
        if (visited[course] == 1) {//if any branch node not completed and again visited - cycle
            return true;
        }
        if (visited[course] == 0) {
            visited[course] = 1;
            for (int adj : adjList.get(course)) {
                if (hasCycle(visited, adjList, adj)) {
                    return true;
                }
            }
            visited[course] = 2;//all children done - so visited
        }
        return false;
    }
}