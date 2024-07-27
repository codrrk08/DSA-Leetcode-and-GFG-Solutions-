//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int helper(int w,int val[],int wt[],int index,int dp[][]){
        // if(w==0)
        // return 0;
        if(index==0){
            return (w/wt[0])*val[0];
        }
        
        if(dp[index][w]!=-1)
        return dp[index][w];
        int notTake = helper(w,val,wt,index-1,dp);
        int take = Integer.MIN_VALUE;
        if(wt[index]<=w){
            take = val[index] + helper(w-wt[index],val,wt,index,dp);
        }
        
        return dp[index][w] = Math.max(take,notTake);
    }
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int dp[][] = new int[N+1][W+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(W,val,wt,N-1,dp);
    }
}