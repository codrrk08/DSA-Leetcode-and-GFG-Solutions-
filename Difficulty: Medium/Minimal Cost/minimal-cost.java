//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int helper(int arr[],int k,int index,int dp[]){
       if(index==arr.length || index>arr.length)
       return 0;
        
       if(dp[index]!=-1)
       return dp[index];
       int min = (int)1e9;
       int take = 0;
       for(int i = 1;i<=k;i++){
           if(index<arr.length-i){
               take = helper(arr,k,index+i,dp) + Math.abs(arr[index]-arr[index+i]);
           }
           min = Math.min(min,take);
       }
    //   min = Math.min(min,take);
       return dp[index] = min;
    }
    public int minimizeCost(int arr[], int k) {
        int dp[] = new int [arr.length+1];
        Arrays.fill(dp,-1);
        
        
        return helper(arr,k,0,dp);
    }
}



//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.minimizeCost(arr, k);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends