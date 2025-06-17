class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph  = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] pair:prerequisites){
            graph.get(pair[1]).add(pair[0]);
        }

        int[] visited = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(hasCycle(graph,visited,i)){
                return false;
            }
        }
        return true;
    }

    public boolean hasCycle(List<List<Integer>> graph, int[] visited, int node){
        if(visited[node] == 1) return true;
        if(visited[node] == 2) return false;

        visited[node] = 1;
        for(int n:graph.get(node)){
            if(hasCycle(graph,visited,n)){
                return true;
            }
        }
        visited[node] = 2;
        return false;
    }
}