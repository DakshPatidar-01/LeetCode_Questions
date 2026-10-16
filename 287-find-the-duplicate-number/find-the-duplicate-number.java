class Solution {
    public int findDuplicate(int[] nums) {
        int curr = 0;
        while (nums[curr] != -1) {
            int next = nums[curr];
            nums[curr] = -1;
            curr = next;
        }
        return curr;
    }
}