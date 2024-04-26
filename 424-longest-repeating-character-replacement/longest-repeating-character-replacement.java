class Solution {
    public int characterReplacement(String s, int k) {
        
        int hash[] = new int[26];
        Arrays.fill(hash,0);
        int l = 0;
        int r = 0;
        int maxlen=0;
        int maxfreq = 0;
        while(r<s.length()){
            char ch = s.charAt(r);
            hash[ch-'A']++;
            maxfreq = Math.max(maxfreq,hash[ch-'A']);
            if((r-l+1)-maxfreq>k){
                hash[s.charAt(l)-'A']--;
                maxfreq=0;
                l++;
            }
            if((r-l+1)-maxfreq<=k)
            maxlen = Math.max(maxlen,r-l+1);
            r++;
        }
        return maxlen;
        
    }
}