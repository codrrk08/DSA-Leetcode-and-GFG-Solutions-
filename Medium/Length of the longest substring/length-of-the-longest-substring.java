//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String S){
        int r = 0;
        int l = 0;
        int maxlen = 1;
        HashMap<Character,Integer> hm = new HashMap<>();
        if(S.length()==1 || S.length()==0)
        return S.length();
        while(r<S.length()){
            char ch = S.charAt(r);
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