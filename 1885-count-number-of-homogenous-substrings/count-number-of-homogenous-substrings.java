class Solution {
    public long homo(String s,int k){
        int i = 0;
        int j = 0 ;
        int n = s.length() ; 
        int[] charFreq = new int[26] ; 
        int dist_count = 0 ;
        long ans = 0 ;
        long count = 0;
        while(j<n){
            charFreq[s.charAt(j)-'a']++;
            if(charFreq[s.charAt(j)-'a']==1){ //Distinct Character
                dist_count++;
            }
            
            //Decreasing Window Size 
            while(dist_count>k){
                charFreq[s.charAt(i)-'a']--;
                if(charFreq[s.charAt(i)-'a']==0){
                    dist_count--;
                }
                i++;
            }
            // if(dist_count==k)
            // count++;
            j++;
            ans+=(j-i+1)%(int)(1e9+7); 
        }
        // System.out.println(count);
        return ans%(int)(1e9+7) ;
    }
    public int countHomogenous(String s) {
        int ans = (int)homo(s,1)-(int)homo(s,0);
        if(ans<0)
        return 999949973;
        return ans;
    }
}