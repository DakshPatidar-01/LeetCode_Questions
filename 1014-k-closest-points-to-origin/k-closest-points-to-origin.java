class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            int distA = a[0] *a[0]+a[1]*a[1];
            int distB = b[0]*b[0]+b[1]*b[1];
            return Integer.compare(distB, distA);
        });

        for(int i=0;i<points.length;i++){
            pq.add(points[i]);
            if(pq.size()>k)pq.poll();
        }
        int i=k-1;
        while(!pq.isEmpty() && i>=0){
            int[] curr = pq.poll();
            ans[i][0]=curr[0];
            ans[i][1]=curr[1];
            i--;
        }
        return ans;
    }
}