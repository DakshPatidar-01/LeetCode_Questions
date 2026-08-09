class Solution {
    public int countGoodSubstrings(String s) {
        if(s.length()<3)return 0;
        int count=0;
        char arr[] = s.toCharArray();
        for(int i=0;i<s.length()-2;i++){
            if(arr[i]!=arr[i+1] && arr[i]!=arr[i+2]&& arr[i+1]!=arr[i+2])count++;
        }
        return count;
    }
}