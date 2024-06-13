//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.padovanSequence(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
  public int padovanSequence(int n)
    {
        // if(n==0||n==1||n==2)
        // return 1;
        
        // return padovanSequence(n-2)+padovanSequence(n-3);
        if(n==0||n==1||n==2)
        return 1;
        final int mod = 1000000007;
        long p0  =1,p1=1,p2=1;
        for(int i=3;i<=n;i++){
            long ans = (p1+p0)%mod;
            p0=p1;
            p1=p2;
            p2=ans;
        }
        return (int)p2;
        
    }
    
}
