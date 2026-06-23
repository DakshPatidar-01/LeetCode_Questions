class Solution {
    public boolean isPalindrome(String s) {

        String ansString = "";

        for(int i = 0; i < s.length(); i++) {

            if(Character.isLetterOrDigit(s.charAt(i))) {
                ansString += Character.toLowerCase(s.charAt(i));
            }
        }

        int left = 0;
        int right = ansString.length() - 1;

        while(left < right) {
            if(ansString.charAt(left) != ansString.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}