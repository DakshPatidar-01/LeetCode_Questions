class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        boolean visited[] = new boolean[n];
        boolean path[] = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++)graph.add(new ArrayList<>());
        for(int e[]:prerequisites)graph.get(e[1]).add(e[0]);
        for(int i=0;i<n;i++){
            if(!visited[i] &&!dfs(i,graph,visited,path))return false;
        }
        return true;
    }

    private boolean dfs(int node,List<List<Integer>> graph,boolean[] visited,boolean[] path){
        visited[node]=true;
        path[node]=true;
        for(int next:graph.get(node)){
            if(!visited[next]){
                if(!dfs(next, graph, visited, path))return false;
            }else if(path[next])return false;
        }
        path[node] = false;
        return true;
    }
}