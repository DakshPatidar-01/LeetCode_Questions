class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1,r=Arrays.stream(piles).max().getAsInt();
        while(l<=r){
            int mid=l+(r-l)/2;
            if(hours(piles,mid)<=h)r=mid-1;
            else l=mid+1;
        }
        return l;
    }

    private long hours(int[] piles,int k){
        long time=0;
        for(int pile:piles){
            time+=pile/k;
            if(pile%k!=0) time++;
        }
        return time;
    }
}