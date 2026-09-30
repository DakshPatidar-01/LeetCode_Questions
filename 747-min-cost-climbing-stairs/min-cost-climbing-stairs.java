class Solution {
    public int minCostClimbingStairs(int[] cost) { 
        int last=cost[1];
        int last2=cost[0];
        for(int i=2;i<cost.length;i++){
            int curr = cost[i]+Math.min(last2, last);
            last2=last;
            last=curr;
        }
        return Math.min(last, last2);
    }
}