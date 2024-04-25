class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int count = 0;
        int len = s.length();
        for(int i = 0;i<len;i++){
            char ch = s.charAt(i);
            hm.put(ch,i);
            if(hm.size()==3){
                count+= 1 + Collections.min(hm.values());
            }
        }
        return count;
        
    }
}