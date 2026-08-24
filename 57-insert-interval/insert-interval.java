class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ans = new ArrayList<>();
        int newIntSt = newInterval[0];
        int newIntE = newInterval[1];
        boolean flag=false;
        for(int i=0;i<intervals.length;i++){
            int currS = intervals[i][0];
            int currE  = intervals[i][1];
            //overlap nhi hai - to abhi wale ko store kro
            if(currE<newIntSt){
                ans.add(new int[]{currS,currE});
                continue;
            }
            // overlap aage nhi hoga toh perfect insert of new Interval
            else if(currS>newIntE){
                if(!flag){
                    ans.add(new int[]{newIntSt,newIntE});
                    flag = true;
                }
                ans.add(new int[]{currS,currE});
            }
            //Overlap kr rha hai 
            else{
                newIntSt = Math.min(currS, newIntSt);
                newIntE = Math.max(currE, newIntE);
            }
        }
        if(!flag)ans.add(new int[]{newIntSt,newIntE});
        return ans.toArray(new int[0][]);
    }
}