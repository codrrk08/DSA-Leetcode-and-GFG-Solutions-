//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeKdigits(String S, int K) {
        int len = S.length();
        if(len==1)
        return "0";
        StringBuilder sb = new StringBuilder(S);
        int f=0;
        while(K!=0){
            for(int i = 0;i<sb.length();i++){
                if(i==sb.length()-1){
                    f=1;
                    break;
                }
                if(sb.charAt(i)>sb.charAt(i+1)){
                    sb.deleteCharAt(i);
                    K--;
                    break;
                }
            }
            if(f==1)
            break;
        }
        if(f==1){
            while(K!=0){
                sb.deleteCharAt(sb.length()-1);
                K--;
            }
        }
        
        while(sb.length()!=0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        if(sb.length()==0){
            sb.append('0');
        }
        return sb.toString();
    }
}