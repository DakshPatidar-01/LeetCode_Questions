class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsetList = new ArrayList<>();
        printSubset(nums, 0, new ArrayList<>(), subsetList);
        return subsetList;
    }

    private void printSubset(int arr[], int idx, List<Integer> current, List<List<Integer>> subsetList) {
        if (idx == arr.length) {
            subsetList.add(new ArrayList<>(current)); 
            return;
        }
        current.add(arr[idx]);
        printSubset(arr, idx + 1, current, subsetList);
        current.remove(current.size() - 1);
        printSubset(arr, idx + 1, current, subsetList);
    }
}