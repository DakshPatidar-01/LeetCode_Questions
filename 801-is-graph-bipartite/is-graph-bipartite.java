class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int color[] = new int[V];
        Arrays.fill(color, -1);

        for(int i=0;i<V;i++){
            if(color[i]==-1 && !dfs(i,graph,color,0))return false;
        }
        return true;
    }

    private boolean dfs(int curr,int[][] graph,int color[],int curColor){
        color[curr]=curColor;

        for(int next:graph[curr]){
            if(color[next]==curColor)return false;
            if(color[next]==-1){
                if(!dfs(next, graph, color, 1-curColor))return false;
            }
        }
        return true;
    }
}