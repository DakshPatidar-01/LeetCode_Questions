class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] path = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i])dfs(i,graph,visited,path);
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<path.length;i++){
            if(!path[i])ans.add(i);
        }
        return ans;
    }

    private boolean dfs(int node, int[][] graph,boolean[] visited ,boolean[] path) {
        visited[node]=true;
        path[node] = true;
        for(int next : graph[node]){
            if(!visited[next]){
                if(!dfs(next,graph,visited,path))return false;
            }else if (path[next])return false;
        }
        path[node] = false;
        return true;
    }
}