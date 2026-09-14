class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        find(0,"",s,wordDict);
        return ans;
    }

    private void find(int i,String word,String s,List<String> wordDict){
        if(i==s.length()){
            ans.add(word);
            return;
        }

        for(int j=i+1;j<=s.length();j++){
            String curr = s.substring(i,j);
            if(!wordDict.contains(curr))continue;
            String next;
            if(word.isEmpty())next=curr;
            else next=word+" "+curr;
            find(j, next, s, wordDict);
        }
    }
}