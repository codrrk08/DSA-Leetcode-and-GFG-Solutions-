class Solution {
    public int solve(int cost[],int index,int dp[]){
        if(index>=cost.length)
        return 0;

        if(dp[index]!=-1)
        return dp[index];
        int oneStep = cost[index] + solve(cost,index+1,dp);
        int twoStep = cost[index] + solve(cost,index+2,dp);
        
        dp[index] = Math.min(oneStep,twoStep);
        return dp[index];
    }
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(solve(cost,0,dp),solve(cost,1,dp));
    }
}