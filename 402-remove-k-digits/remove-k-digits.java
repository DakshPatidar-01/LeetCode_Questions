class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder st = new StringBuilder();
        for(char ch: num.toCharArray()){
            while(st.length()>0 && st.charAt(st.length()-1)> ch && k>0){
                st.deleteCharAt(st.length()-1);
                k--;
            }
            st.append(ch);
        }
        while (k>0) {
            st.deleteCharAt(st.length()-1);
            k--;
        }
        int i=0;
        while(i<st.length()-1 && st.charAt(i)=='0'){
            i++;
        }

        return st.length()<1?"0":st.substring(i);
    }
}