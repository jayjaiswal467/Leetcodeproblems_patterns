class Solution {

    public boolean isPalindrome(String s) {
        return check(s, 0, s.length() - 1);
    }

    boolean check(String s, int low, int high) {

        int len = high - low + 1;

        if (len == 0 || len == 1) {
            return true;
        }

        if (s.charAt(low) != s.charAt(high)) {
            return false;
        }

        return check(s, low + 1, high - 1);
    }
}