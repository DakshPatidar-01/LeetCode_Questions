class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int totalOnes= 0;
        for(int x : nums) {
            if(x == 1)totalOnes++;
        }
        if(totalOnes == 0 || totalOnes == n) return 0;
        int currZero = 0;
        for(int i=0;i<totalOnes;i++) {
            if(nums[i]==0)currZero++;
        }
        int minZero = currZero;
        for(int i=1;i<n;i++) {
            int remove=nums[i-1];
            int add = nums[(i+totalOnes-1)%n];
            if(remove==0) currZero--;
            if(add==0) currZero++;
            minZero = Math.min(minZero, currZero);
        }
        return minZero;
    }
}