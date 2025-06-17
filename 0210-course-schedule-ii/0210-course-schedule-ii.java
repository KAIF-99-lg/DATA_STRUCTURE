import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        // Build the graph
        for (int[] pair : prerequisites) {
            graph.get(pair[1]).add(pair[0]);
        }

        int[] visited = new int[numCourses]; // 0 = unvisited, 1 = visiting, 2 = visited
        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, graph, visited, order)) {
                return new int[0]; // cycle detected
            }
        }

        // Reverse to get correct order
        Collections.reverse(order);

        // Convert List<Integer> to int[]
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
            result[i] = order.get(i);

        return result;
    }

    private boolean hasCycle(int node, List<List<Integer>> graph, int[] visited, List<Integer> order) {
        if (visited[node] == 1) return true;  // cycle found
        if (visited[node] == 2) return false; // already processed

        visited[node] = 1; // mark as visiting
        for (int neighbor : graph.get(node)) {
            if (hasCycle(neighbor, graph, visited, order))
                return true;
        }

        visited[node] = 2; // mark as visited
        order.add(node);  // add to order when done
        return false;
    }
}
