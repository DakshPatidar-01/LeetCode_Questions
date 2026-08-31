class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while (!st.isEmpty() && temperatures[st.peek()]<temperatures[i]) {//check kiya ki current purane walo ka ans ban sakta hai ?
                int j=st.pop(); //toh idx nikalo
                ans[j]=i-j;// or dalo
            }
            st.push(i);
        }
        return ans;
    }
}