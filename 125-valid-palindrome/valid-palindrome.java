class Solution {
    public boolean isPalindrome(String s) {
        String currString = s.toLowerCase();
        int left=0,right=currString.length()-1;
        while(left<right){
            if (!Character.isLetterOrDigit(currString.charAt(left))) {
                left++;
                continue;
            }

            if (!Character.isLetterOrDigit(currString.charAt(right))) {
                right--;
                continue;
            }

            if(currString.charAt(left)!=currString.charAt(right))return false;
            right--;
            left++; 
        }
        return true;
    }
}