import java.util.*;

class Solution {
    public List<String> letterCombinations(String s) {
        int n = s.length();
        int idx = 0;
        String diary = "";

        List<String> res = new ArrayList<>();

        HashMap<Character, String> f = new HashMap<>();
        f.put('2', "abc");
        f.put('3', "def");
        f.put('4', "ghi");
        f.put('5', "jkl");
        f.put('6', "mno");
        f.put('7', "pqrs");
        f.put('8', "tuv");
        f.put('9', "wxyz");

        if(n == 0) {
            return res;
        }

        return fun(s, n, idx, diary, res, f);
    }

    public List<String> fun(String s, int n, int idx,
                            String diary, List<String> res,
                            HashMap<Character, String> f) {

        if(idx == n) {
            res.add(diary);
            return res;
        }

        String choice = f.get(s.charAt(idx));

        for(int j = 0; j < choice.length(); j++) {

            diary = diary + choice.charAt(j);

            fun(s, n, idx + 1, diary, res, f);

            diary = diary.substring(0, diary.length() - 1);
        }

        return res;
    }
}