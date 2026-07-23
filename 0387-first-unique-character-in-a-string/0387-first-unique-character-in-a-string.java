class Solution {
    public int firstUniqChar(String s) {

        int n = s.length();

        HashMap<Character, Integer> f = new HashMap<>();

        // Count frequency
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            f.put(ch, f.getOrDefault(ch, 0) + 1);
        }

        // Find first unique character
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (f.get(ch) == 1) {
                return i;
            }
        }

        return -1;
    }
}