class Solution {
    public int findCheapestPrice(int n,int[][] flights,int src,int dst,int k) {
        List<List<int[]>> graph=new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int[] f:flights)graph.get(f[0]).add(new int[]{f[1],f[2]});
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{src,0,0});
        int[][] dist=new int[n][k+2];
        for(int[] row:dist) Arrays.fill(row,Integer.MAX_VALUE);
        dist[src][0]=0;
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int node=cur[0],cost=cur[1],stops=cur[2];
            if(node==dst)return cost;
            if(stops==k+1)continue;
            for(int[] next:graph.get(node)){
                int v=next[0],price=next[1];
                int newCost=cost+price;
                if(newCost<dist[v][stops+1]){
                    dist[v][stops+1]=newCost;
                    pq.add(new int[]{v,newCost,stops+1});
                }
            }
        }
        return -1;
    }
}