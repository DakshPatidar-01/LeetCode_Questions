
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        back("",n,0,ans);
        return ans;
    }

    private void back(String curr,int n,int length,List<String> ans){
        if(length==n*2){
            if(isValid(curr))ans.add(curr);
            return;
        }
        curr+='(';
        back(curr, n, length+1, ans);
        curr=curr.substring(0,curr.length()-1);
        curr+=')';
        back(curr, n, length+1, ans);
    }

    private boolean isValid(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')count++;
            else count--;

            if(count<0)return false;
        }

        return count==0;
    }
}