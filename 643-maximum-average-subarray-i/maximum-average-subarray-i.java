class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double windSum=0;
        for(int i=0;i<k;i++){
            windSum+=nums[i];
        }
        double ans = windSum/k;
        for(int i=k;i<nums.length;i++){
            windSum+=nums[i];
            windSum-=nums[i-k];
            ans=Math.max(ans, windSum/k);
        }
        return ans;
    }
}