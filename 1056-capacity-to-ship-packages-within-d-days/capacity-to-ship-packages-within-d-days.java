class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l=0,r=0;
        for(int w:weights){
            l=Math.max(l,w);
            r+=w;
        }
        while(l<=r){
            int mid=l+(r-l)/2;
            if(canShip(weights,days,mid))r=mid-1;
            else l=mid+1;
        }
        return l;
    }
    private boolean canShip(int[] weights,int days,int cap){
        int load=0,count=1;
        for(int w:weights){
            if(load+w>cap){
                count++;
                load=0;
            }
            load+=w;
        }
        return count<=days;
    }
}