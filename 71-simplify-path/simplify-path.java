class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String parts[] = path.split("/");
        for(String curr:parts){
            if(curr.equals(".")|| curr.equals(""))continue;
            if(curr.equals("..")){
                if(!st.isEmpty())st.pop();
            }
            else st.push(curr);
        }

        StringBuilder ans = new StringBuilder();
        for(String curr:st){
            ans.append('/').append(curr);
        }
        return ans.length()==0?"/":ans.toString();
    }
}