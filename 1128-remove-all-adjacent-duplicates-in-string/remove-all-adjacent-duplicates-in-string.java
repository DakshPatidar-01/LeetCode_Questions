import java.util.Stack;

class Solution {
    public String removeDuplicates(String s) {
        //abbaca
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(!st.isEmpty() && st.peek()==ch)st.pop();
            else st.push(ch);
        }
        String temp="";
        while (!st.isEmpty()) {
            temp+=st.pop();
        }
        String ans="";
        for(int i=temp.length()-1;i>=0;i--){
            ans+=temp.charAt(i);
        }
        return ans;
        
    }
    
}