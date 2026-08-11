class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=0, left=0;
        int minlen=Integer.MAX_VALUE;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            if(sum>=target)minlen=Math.min(minlen,r-left+1);
            while(sum>target){
                sum-=nums[left++];
                if(sum>=target)minlen=Math.min(minlen,r-left+1);
            }
        }
        if(minlen==Integer.MAX_VALUE)minlen=0;
        return minlen;
    }
}