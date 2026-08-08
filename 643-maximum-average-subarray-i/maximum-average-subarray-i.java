class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if(nums.length<k)return -1; 
        int windSum=0;
        for(int i=0;i<k;i++){
            windSum+=nums[i];
        }
        int ans = windSum;
        for(int i=k;i<nums.length;i++){
            windSum=windSum+nums[i]-nums[i-k];
            ans=Math.max(ans, windSum);
        }
        return (double)ans/k;
    }
}