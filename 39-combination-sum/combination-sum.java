class Solution {
   public void solve(int[] arr, int i, int target, List<List<Integer>> ans, ArrayList<Integer> combin){

        if(target == 0){
            ans.add(new ArrayList<>(combin));
            return;
        }

        if(i == arr.length || target < 0){
            return;
        }

        // pick element
        combin.add(arr[i]);
        solve(arr, i, target - arr[i], ans, combin);

        // backtrack
        combin.remove(combin.size() - 1);

        // skip element
        solve(arr, i + 1, target, ans, combin);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> combin = new ArrayList<>();

        solve(candidates, 0, target, ans, combin);

        return ans;
    }
}