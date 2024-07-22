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
            int [][]points=new int[N][3];
            for(int i=0;i<N;i++){
                for(int j=0;j<3;j++){
                    points[i][j]=sc.nextInt();
                }
            }
            Solution obj=new Solution();
            int res=obj.maximumPoints(points,N);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    // public int helper(int index,int last,int points[][],int dp[][]){
    //     // if(index==n)
    //     // return 0;
        
    //     // int max = Integer.MIN_VALUE;
    //     // for(int i = 0;i<3;i++){
    //     //     if(index!=0){
    //     //         if(points[index-1][i]!=-1){
    //     //             int t = points[index][i];
    //     //             points[index][i] = -1;
    //     //             int x = t+helper(points,n,index+1);
    //     //             max = Math.max(max,x);
    //     //             points[index][i] = t;
    //     //         }
    //     //     }
    //     //     else{
    //     //         int t = points[index][i];
    //     //         points[index][i] = -1;
    //     //         int x = t+helper(points,n,index+1);
    //     //         max = Math.max(max,x);
    //     //         points[index][i] = t;
    //     //     }
    //     // }
    //     // return max;
    //     if (dp[index][last] != -1) return dp[index][last];

    //     // Base case: When it's the first day (day == 0)
    //     if (index == 0) {
    //         int max = 0;
    //         for (int i = 0; i <= 2; i++) {
    //             if (i != last)
    //                 max = Math.max(max, points[0][i]);
    //         }
    //         return dp[index][last] = max; // Store and return the result
    //     }

    //     int max = 0;
    //     // Loop through the three activities on the current day
    //     for (int i = 0; i <= 2; i++) {
    //         if (i != last) {
    //             // Calculate the points for the current activity and recursively
    //             // calculate the maximum points for the previous day
    //             int activity = points[index][i] + helper(index - 1, i, points, dp);
    //             max = Math.max(max, activity); // Update the maximum points
    //         }
    //     }

    //     return dp[index][last] = max; 
    // }
    public int maximumPoints(int points[][],int n){
        // int dp[][] = new int[N+1][4];
        // for (int[] row : dp)
        //     Arrays.fill(row, -1);
        // return helper(N-1,3,points,dp);
        int[][] dp = new int[n][4];
        
        // Initialize the first day's maximum points based on the available choices
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        // Iterate through each day and each activity
        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0; // Initialize the maximum points for the current day and last activity
                // Consider each possible task for the current day
                for (int task = 0; task <= 2; task++) {
                    if (task != last) { // Ensure that the current task is different from the last
                        // Calculate the points for the current activity and add it to the maximum points from the previous day
                        int activity = points[day][task] + dp[day - 1][task];
                        // Update the maximum points for the current day and last activity
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
        }

        // Return the maximum points achievable after all days (last activity is 3)
        return dp[n - 1][3];
    }
}