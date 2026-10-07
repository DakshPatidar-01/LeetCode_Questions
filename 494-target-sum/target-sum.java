class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String,Integer> map = new HashMap<>();
        return solve(0,0,nums,target,map);
    }

    private int solve(int idx,int currSum,int[] nums,int target,Map<String,Integer> map){
        if(idx==nums.length)return currSum==target?1:0;
        String key = idx+","+currSum;
        if(map.containsKey(key))return map.get(key);
        int plus = solve(idx+1, currSum+nums[idx], nums, target,map);
        int minus = solve(idx+1, currSum-nums[idx], nums, target,map);
        int ways = plus+minus;
        map.put(key, ways);
        return ways;
    }
}