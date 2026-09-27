class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length,m=heights[0].length;
        int[][] dist = new int[n][m];
        for(int[] row:dist)Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        dist[0][0]=0;
        pq.add(new int[]{0,0,0});
        int dir[][]={{1,0},{-1,0},{0,1},{0,-1}};
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int i=curr[0],j=curr[1],effort=curr[2];
            if(i==n-1&&j==m-1)return effort;
            if(effort>dist[i][j])continue;
            for(int[] d:dir){
                int ni=i+d[0],nj=j+d[1];
                if(ni<0||nj<0||ni>=n||nj>=m)continue;
                int edge = Math.abs(heights[i][j]-heights[ni][nj]);
                int newEffort = Math.max(effort, edge);
                if(newEffort<dist[ni][nj]){
                    dist[ni][nj]=newEffort;
                    pq.add(new int[]{ni,nj,newEffort});
                }
            }
        }
        return 0;
    }
}