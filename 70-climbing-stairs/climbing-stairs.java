class Solution {
    // public int helper(int n,int start,int count,int dp[]){
    //     if(start==n){
    //         return 1;
    //     }
    //     if(start>n)
    //     return 0;

    //     if(dp[start]!=-1)
    //     return dp[start];

    //     int leftCount=helper(n,start+1,count,dp);
    //     int rightCount=helper(n,start+2,count,dp);
    //     count = leftCount+rightCount;
    //     return dp[start] = count;
    // }
    public int helper(int n,int dp[]){
        if(n<=2)
        return n;
        
        if(dp[n]!=-1)
        return dp[n];
        int jumpOnce = helper(n-1,dp);
        int jumpTwice = helper(n-2,dp);
        
        return dp[n] = jumpOnce+jumpTwice;
}

    public int climbStairs(int n) {
        // if(n==1|| n==2)
        // return n;
        // int dp[] = new int[n+1];
        // // Arrays.fill(dp,-1);
        // // return helper(n,0,0,dp);
        // dp[1] = 1;
        // dp[2] = 2;

        // for(int i=3;i<=n;i++){
        //     dp[i] = dp[i-1]+dp[i-2];
        // }
        // return dp[n];
        int dp[]  =new int[n+1];
        Arrays.fill(dp,-1);
        // dp[0] = 0;
        // dp[1] = 1;
        // for(int i = 2;i<n;i++){
        //     dp[i] = dp[i-1] + dp[i-2];
        // }
        return helper(n,dp);
    }
}