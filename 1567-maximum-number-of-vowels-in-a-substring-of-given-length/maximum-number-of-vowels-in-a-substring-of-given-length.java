class Solution {
    public int maxVowels(String s, int k) {
        char[] arr = s.toCharArray();
        int count=0;
        for(int i=0;i<k;i++){
            if(isVowel(arr[i]))count++;
        }
        int ans =count;
        for(int i=k;i<arr.length;i++){
            if(isVowel(arr[i]))count++;
            if(isVowel(arr[i-k]))count--;
            ans=Math.max(ans, count);
        }
        return ans;
    }

    private boolean isVowel(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
}