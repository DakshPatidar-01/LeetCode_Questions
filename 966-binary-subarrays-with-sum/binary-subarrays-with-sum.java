class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int left=0,sum=0,count=0,zeros=0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while(left<right && sum>goal){
                sum-=nums[left++];
                zeros=0;
            }
            if(sum==goal){
                while(left<right && nums[left]==0){
                    left++;
                    zeros++;
                }
                count+=zeros+1;
            }
        }
        return count;
    }
}