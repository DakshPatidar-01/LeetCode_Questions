class Solution {
    public boolean validPalindrome(String s) {
        return isValid(s, 0, s.length() - 1, true);
    }
    private boolean isValid(String s, int left, int right, boolean canDelete) {
        if (left >= right) {
            return true;
        }
        if (s.charAt(left) == s.charAt(right)) {
            return isValid(s, left + 1, right - 1, canDelete);
        }
        if (!canDelete) {
            return false;
        }
        return isValid(s, left + 1, right, false)
                || isValid(s, left, right - 1, false);
    }
}