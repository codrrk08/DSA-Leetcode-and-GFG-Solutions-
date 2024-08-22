class Solution {
    public long homo(String s){
        int i = 0;
        int j = 0 ;
        int n = s.length() ; 
        HashMap<Character,Integer> hm = new HashMap<>();
        long ans = 0 ;
        while(j<n){
            char ch = s.charAt(j);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            while(hm.size()>1){
                char startChar = s.charAt(i);
                hm.put(startChar, hm.get(startChar) - 1);
                if (hm.get(startChar) == 0) {
                    hm.remove(startChar);
                }
                i++;
            } 
            ans+= (j-i+1) %(int)(1e9+7);
            j++;
        }
        return ans%(int)(1e9+7);
            
    }
    public int countHomogenous(String s) {
        // int ans = (int)homo(s,1)-(int)homo(s,0);
        // // if(ans<0)
        // return 999949973;
        return (int)homo(s);
        // return ans;
    }
}