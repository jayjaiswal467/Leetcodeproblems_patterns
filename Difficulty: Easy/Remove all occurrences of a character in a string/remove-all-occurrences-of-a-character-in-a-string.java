class Solution {

    public void removeCharacter(StringBuilder s, char c) {
        fun(s, 0, c);
    }

    public void fun(StringBuilder s, int i, char c) {

        // Base case
        if (i == s.length()) {
            return;
        }

        // If current character is c, remove it
        if (s.charAt(i) == c) {
            s.deleteCharAt(i);

            
            fun(s, i, c);
        }
        else {
            // Current character is fine, move ahead
            fun(s, i + 1, c);
        }
    }
}