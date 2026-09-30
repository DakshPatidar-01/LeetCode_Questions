class Solution {
    public int climbStairs(int n) {
        if(n<=3)return n;
        int last2=2;
        int last = 3;
        int ans=0;
        for(int i=4;i<=n;i++){
            ans=last2+last;
            last2=last;
            last=ans;
        }
        return ans;
    }
}