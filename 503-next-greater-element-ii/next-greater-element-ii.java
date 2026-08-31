class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n=nums.length;
        int ans[] =new int[nums.length];
        Arrays.fill(ans, -1);
        for(int i=0;i<nums.length*2;i++){
            int actualIdx = i%n;
            while (!st.isEmpty() && nums[st.peek()]<nums[actualIdx]) {
                ans[st.pop()]=nums[actualIdx];
            }
            if(i<n)st.push(actualIdx);

        }
        return ans;
    }
}