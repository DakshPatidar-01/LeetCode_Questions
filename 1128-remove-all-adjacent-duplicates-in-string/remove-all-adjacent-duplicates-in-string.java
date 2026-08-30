class Solution {
    public String removeDuplicates(String s) {
        //abbaca
        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(!st.isEmpty() && st.peek()==ch){
                st.pop();
                ans.deleteCharAt(ans.length()-1);
            }else{
                st.push(ch);
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}