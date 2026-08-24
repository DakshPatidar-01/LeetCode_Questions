
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0], b[0]));
        ArrayList<int[]> arr = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int nextS = intervals[i][0];
            int nextE = intervals[i][1];

            if(end>=nextS){
                end = Math.max(end, nextE);
            }else{
                arr.add(new int[]{start,end});
                start=nextS;
                end=nextE;
            }
        }
        arr.add(new int[]{start,end});
        return arr.toArray(new int[0][]);
    }
}