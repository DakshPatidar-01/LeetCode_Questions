class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans=new int[nums.length];
        int l=0,r=nums.length-1,k=r;
        while(l<=r)
            if(nums[l]*nums[l]>nums[r]*nums[r]){
                ans[k--]=nums[l]*nums[l];
                l++;
            }else{
                ans[k--]=nums[r]*nums[r];
                r--;
            }
        return ans;
    }
}