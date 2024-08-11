//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    // public int helper(int arr[],int n,int start,int dp[]){
    //     if(start==n-1){
    //         return 0;
    //     }
    //     // if(start>n-1)
    //     // return 0;
    //     // curr = start;
    //     if(dp[start]!=-1)
    //     return dp[start];
    //     int leftDiff = helper(arr,n,start+1,dp) + Math.abs(arr[start]-arr[start+1]);
    //     int rightDiff=Integer.MAX_VALUE;
    //     if(start<n-2)
    //     rightDiff = helper(arr,n,start+2,dp) + Math.abs(arr[start]-arr[start+2]);
        
        
    //     return dp[start] = Math.min(leftDiff,rightDiff);
    // }
    public int helper(int n,int arr[],int dp[]){
    // 	if(n<0)
    // 	return 0;
    	if(n==0)
    	return 0;
    
        if(dp[n]!=-1)
        return dp[n];
    	int twice = Integer.MAX_VALUE;
    	int once = helper(n-1,arr,dp) + Math.abs(arr[n]-arr[n-1]);
    	if(n>=2)
    	twice = helper(n-2,arr,dp) + Math.abs(arr[n]-arr[n-2]);

	    return dp[n] =  Math.min(once,twice);
}
    public int minimumEnergy(int arr[],int N){
        int dp[] = new int [N+1];
        Arrays.fill(dp,-1);
        
        
        return helper(N-1,arr,dp);
    }
}