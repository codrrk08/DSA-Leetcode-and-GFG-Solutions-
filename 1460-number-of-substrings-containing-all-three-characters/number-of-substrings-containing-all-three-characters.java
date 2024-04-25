class Solution {
    public int numberOfSubstrings(String s) {
        // HashMap<Character,Integer> hm = new HashMap<>();
        // int count = 0;
        // int len = s.length();
        // for(int i = 0;i<len;i++){
        // char ch = s.charAt(i);
        // hm.put(ch,i);
        // if(hm.size()==3){
        // count+= 1 + Collections.min(hm.values());
        // }
        // }
        // return count;
        int chars[] = new int[3];
        Arrays.fill(chars, -1);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a'] = i;
            if (chars[0] != -1 && chars[1] != -1 && chars[2] != -1){
                count += 1 + Math.min(Math.min(chars[0], chars[1]), chars[2]);
            }
        }
        return count;

    }
}