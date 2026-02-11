class Solution {
    //TC-O(V+E) and SC-O(V+E), due to recursion stack
    //Topological Sorting, if cycle present, all are dependents so return false
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] result = new int[numCourses];
        Deque<Integer> stack = new ArrayDeque<>();
        int[] visited = new int[numCourses];//0-unvisited, 1-visiting, 2- visited
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] course : prerequisites) {//u,v - v first and u second, so v->u
            adjList.get(course[1]).add(course[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (hasCycle(visited, adjList, i, stack)) {
                    return new int[0];
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {//in reverse order we need so pop and store in result
            result[i] = stack.pop();
        }
        return result;
    }

    private boolean hasCycle(int[] visited, List<List<Integer>> adjList,
            int course, Deque<Integer> stack) {
        if (visited[course] == 1) {//if any branch node not completed and again visited - cycle
            return true;
        }
        if (visited[course] == 0) {
            visited[course] = 1;
            for (int adj : adjList.get(course)) {
                if (hasCycle(visited, adjList, adj, stack)) {
                    return true;
                }
            }
            visited[course] = 2;//all children done - so visited
            stack.push(course);//leaf nodes first
        }
        return false;
    }
}