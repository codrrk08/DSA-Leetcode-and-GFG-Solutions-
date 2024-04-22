class Solution {
    public int lengthOfLongestSubstring(String s) {
        int r = 0;
        int l = 0;
        int maxlen = 1;
        HashMap<Character,Integer> hm = new HashMap<>();
        if(s.length()==1 || s.length()==0)
        return s.length();
        while(r<s.length()){
            char ch = s.charAt(r);
            if(hm.containsKey(ch) && hm.get(ch)>=l){
                l = hm.get(ch);
                l++;
            }
            hm.put(ch,r);
            maxlen = Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;

    }
}