//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int d;
            d = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countPartitions(n, d, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int helper(int arr[],int sum,int index,int dp[][]){
        if(index==arr.length-1){
            if(sum==0 && arr[index]==0)
            return 2;
            if(arr[index]==sum)
            return 1;
            if(sum==0)
            return 1;
            
            return 0;
        }
        // return 1;
        // if((sum-curr)<curr)
        // retint urn 0;
        if(dp[index][sum]!=-1)
        return dp[index][sum];
        
        int leftSum = 0;
        if(arr[index]<=sum)
        leftSum = helper(arr,sum-arr[index],index+1,dp)%1000000007;
        int rightSum = helper(arr,sum,index+1,dp)%1000000007;
        
        return dp[index][sum] = (leftSum+rightSum)%1000000007;
    }
    public static int countPartitions(int n, int d, int[] arr) {
        int sum  =0;
        for(int x:arr){
            sum+=x;
        }
        
        if(sum-d<0 || (sum-d)%2==1)
        return 0;
        
        int s2 = (sum-d)/2;
        int dp[][] = new int[n][s2+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(arr,s2,0,dp)%1000000007;
        
    }
}
        
