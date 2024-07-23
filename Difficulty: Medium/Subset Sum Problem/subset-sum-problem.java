//{ Driver Code Starts
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
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    
    
    static Boolean helper(int n,int arr[],int sum,int index,int dp[][]){
        if(sum==0)
        return true;
        if(index==0)
        return sum==arr[index];
        
        if(dp[index][sum]!=-1)
        return dp[index][sum]==0?false:true;
        boolean take = false;
        if(arr[index]<=sum)
        take = helper(n,arr,sum-arr[index],index-1,dp);
        
        boolean notTake = helper(n,arr,sum,index-1,dp);
        
        dp[index][sum] = (take||notTake)?1:0;
        return take||notTake;
    
    }
    static Boolean isSubsetSum(int N, int arr[], int sum){
        int dp[][] = new int[N+1][sum+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(N,arr,sum,N-1,dp);
    }
}