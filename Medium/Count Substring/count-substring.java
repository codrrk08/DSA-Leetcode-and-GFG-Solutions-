//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.countSubstring(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int countSubstring(String s) {
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
        
