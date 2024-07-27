//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int helper(int price[],int index,int maxwt,int dp[][]){
        
        if(index==0){
            return (maxwt/(index+1))*price[index];
        }
        
        if(dp[index][maxwt]!=-1)
        return dp[index][maxwt];
        int notTake =0+helper(price,index-1,maxwt,dp);
        int take = Integer.MIN_VALUE;
        if(index+1<=maxwt)
        take = price[index] + helper(price,index,maxwt-(index+1),dp);
        
        return dp[index][maxwt] = Math.max(take,notTake);
    }
    public int cutRod(int price[], int n) {
        
        int dp[][] = new int[n+1][n+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(price,n-1,n,dp);
    }
}