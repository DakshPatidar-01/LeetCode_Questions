class Solution {
    public int climbStairs(int n) {
        if(n==1 || n==2 || n==3)return n;
        int last = 1;
        int first = 2;
        int curr=0;
        for(int i = 3; i <= n; i++)
        {
            curr = last + first;
            last = first;
            first = curr;
        }

        return first;
    }
}