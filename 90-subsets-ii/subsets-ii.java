class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        solve(0,nums,new ArrayList<>(),ans);
        return ans;
    }

    private void solve(int idx, int[] nums,ArrayList<Integer> curr, List<List<Integer>> ans){
        ans.add(new ArrayList<>(curr));
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i-1]==nums[i])continue;
            curr.add(nums[i]);
            solve(i+1, nums, curr, ans);
            curr.remove(curr.size()-1);
        }
    }
}