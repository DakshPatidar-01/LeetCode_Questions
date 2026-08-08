class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length<k)k=nums.length-1;
        HashSet<Integer> set= new HashSet<>();
        for(int i=0;i<k;i++){
            if(set.contains(nums[i]))return true;
            else set.add(nums[i]);
        }

        for(int i=k;i<nums.length;i++){
            if(set.contains(nums[i]))return true;
            else{
                set.add(nums[i]);
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}