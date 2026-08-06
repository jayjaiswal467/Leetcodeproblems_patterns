import java.util.*;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }
            // Closing brackets
            else {

                // No opening bracket available
                if (st.isEmpty()) {
                    return false;
                }

                // Check matching
                if (ch == ')' && st.peek() != '(') {
                    return false;
                }

                if (ch == '}' && st.peek() != '{') {
                    return false;
                }

                if (ch == ']' && st.peek() != '[') {
                    return false;
                }

                // Remove matching opening bracket
                st.pop();
            }
        }

        if (st.isEmpty()) {
    return true;
}
return false;
    }
}