class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++) graph.add(new ArrayList<>());
        for(int[] e : times)graph.get(e[0]).add(new int[]{e[1],e[2]});
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int node=curr[0], d=curr[1];
            if(d>dist[node]) continue;
            for(int[] next:graph.get(node)){
                int v=next[0], wt=next[1];
                if(d+wt<dist[v]){
                    dist[v]=d+wt;
                    pq.add(new int[]{v,dist[v]});
                }
            }
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            ans=Math.max(ans,dist[i]);
        }
        return ans;
    }
}