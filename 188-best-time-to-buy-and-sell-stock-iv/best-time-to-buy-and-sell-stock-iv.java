class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n+1][2][k+1];
        for(int i = n-1;i>=0;i--){
            for(int j = 0;j<=1;j++){
                for(int x = 1;x<=k;x++){
                    int profit = 0;
                    if(j==1){
                        dp[i][j][x]= Math.max(-prices[i] + dp[i+1][0][x],dp[i+1][1][x]);
                    }
                    else
                    dp[i][j][x] = Math.max(prices[i] + dp[i+1][1][x-1],dp[i+1][0][x]);
                    
                }
            }
        }

        // return helper(prices,0,1,0,dp);
        return dp[0][1][k];
    }
}