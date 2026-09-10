class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean used[] = new boolean[nums.length];
        Arrays.sort(nums);
        solve(new ArrayList<>(),nums,used,ans);
        return ans;
    }

    private void solve(ArrayList<Integer> curr,int nums[],boolean used[],List<List<Integer>> ans){
        if(curr.size()==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i])continue;
            if(i>0 && nums[i]==nums[i-1] && !used[i-1])continue;
            curr.add(nums[i]);
            used[i]=true;
            solve(curr, nums, used, ans);
            curr.removeLast();
            used[i]=false;
        }
    }
}