class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        collectAllPermute(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void collectAllPermute(int[] arr, int idx, List<Integer> current, List<List<Integer>> ans) {
        if (idx == arr.length) {
            ans.add(new ArrayList<>(current)); // copy
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
            current.add(arr[idx]);
            collectAllPermute(arr, idx + 1, current, ans);
            current.remove(current.size() - 1);
            temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
    }
}