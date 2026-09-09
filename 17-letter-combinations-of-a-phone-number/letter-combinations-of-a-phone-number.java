class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return ans;

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        solve(0,digits,"",map,ans);
        return ans;
    }

    private void solve(int idx,String digits,String curr,HashMap<Character,String> map,List<String> ans){
        if(idx==digits.length()){
            ans.add(curr);
            return;
        }

        String letters = map.get(digits.charAt(idx));
        for(char ch:letters.toCharArray()){
            curr+=ch;
            solve(idx+1, digits, curr, map, ans);
            curr=curr.substring(0,curr.length()-1);
        }
    }
}