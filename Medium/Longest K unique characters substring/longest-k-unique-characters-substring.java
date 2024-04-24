//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        int l = 0;
        int r = 0;
        int maxlen = -1;
        HashMap<Character,Integer> hm = new HashMap<>();
        while(r<s.length()){
            char ch = s.charAt(r);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            if(hm.size()==k){
                maxlen = Math.max(maxlen,r-l+1);
            }
            else if(hm.size()>k){
                hm.put(s.charAt(l),hm.get(s.charAt(l))-1);
                if(hm.get(s.charAt(l))==0)
                hm.remove(s.charAt(l));
                l++;
            }
            r++;
        }
        return maxlen;
        
    }
}