class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int n = ransomNote.length();
        int m = magazine.length();
        
        HashMap<Character,Integer>have = new HashMap<>();
        HashMap<Character,Integer>need = new HashMap<>();

        for(int i=0;i<n;i++){
            need.put(ransomNote.charAt(i),need.getOrDefault(ransomNote.charAt(i),0)+1);
        }
        for(int j=0;j<m;j++){
            have.put(magazine.charAt(j),have.getOrDefault(magazine.charAt(j),0)+1);
        }

        for(char ch:need.keySet()){
            int fneed = need.get(ch);
            int fhave = have.getOrDefault(ch,0);

            if(fneed>fhave){
                return false;
            }
        }
    return true;
    }
}