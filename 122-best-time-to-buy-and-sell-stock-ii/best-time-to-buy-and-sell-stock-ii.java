class Solution {
    public int helper(int prices[],int index,int canBuy,int dp[][]){
        if(index==prices.length)
        return 0;
        
        if(dp[index][canBuy]!=-1)
        return dp[index][canBuy];
        int profit=0;
        if(canBuy==1){
            profit = Math.max(-prices[index] + helper(prices,index+1,0,dp),helper(prices,index+1,1,dp));
        }
        else{
            profit = Math.max(prices[index] + helper(prices,index+1,1,dp),helper(prices,index+1,0,dp));
        }
        return dp[index][canBuy] = profit;
    }
    public int maxProfit(int[] prices) {
        // int n = prices.length;
        // int dp[][] = new int[n+1][2];
        // for(int row[]:dp){
        //     Arrays.fill(row,-1);
        // }
        // return helper(prices,0,1,dp);
        int n = prices.length;
        int dp[][] = new int[n+1][2];
        
        dp[n][0] = 0;
        dp[n][1] = 0;

        for(int i = n-1;i>=0;i--){
            for(int j = 0;j<=1;j++){
                int profit = 0;
                if(j==1){
                    profit = Math.max(-prices[i] + dp[i+1][0],dp[i+1][1]);
                }
                else
                profit = Math.max(prices[i] + dp[i+1][1],dp[i+1][0]);
                dp[i][j] = profit;
            }
        }
        return dp[0][1];


    }
}