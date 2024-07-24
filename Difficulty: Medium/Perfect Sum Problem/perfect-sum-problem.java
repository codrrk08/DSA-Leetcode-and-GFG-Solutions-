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
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    public int helper(int arr[],int index,int sum,int dp[][]){
    //   if(sum==0)
    //       return 1;
      if(index==arr.length-1){
          if(sum == 0 && arr[index] == 0)
          return 2;
          if(sum==arr[index])
          return 1;
          if(sum==0)
          return 1;
          
          return 0;
        }
        
        // if(sum==0 && arr[0]==0)
        // return 2;
      if(dp[index][sum]!=-1)
      return dp[index][sum];
      int pick = 0;
      if(arr[index]<=sum)
      pick= helper(arr,index+1,sum-arr[index],dp)%1000000007;
       
      int notPick= helper(arr,index+1,sum,dp)%1000000007;
      return dp[index][sum] = (pick+notPick)%1000000007;
    }

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    int curr = 0;
	    int dp [][]= new int[n+1][sum+1];
	    for(int row[]:dp){
	        Arrays.fill(row,-1);
	    }
	    return helper(arr,0,sum,dp)%1000000007;
	} 
}
// class Solution{
//     public int helper(int arr[],int index,int curr,int sum){
//         if(index==arr.length){
//             if(curr==sum)
//             return 1;
//             else
//             return 0;
//         }
//         // if(dp[index][curr]!=-1)
//         // return dp[index][curr];
//         curr+=arr[index];
//         int leftSum = helper(arr,index+1,curr,sum)%1000000009;
//         curr-=arr[index];
//         int rightSum = helper(arr,index+1,curr,sum)%1000000009;
        
//         return (leftSum+rightSum)%1000000009;
//     }

// 	public int perfectSum(int arr[],int n, int sum) 
// 	{ 
// 	    int curr = 0;
// 	    int dp [][]= new int[n+1][sum+1];
// 	    for(int row[]:dp){
// 	        Arrays.fill(row,-1);
// 	    }
// 	    return helper(arr,0,curr,sum)%1000000009;
// 	} 
// }