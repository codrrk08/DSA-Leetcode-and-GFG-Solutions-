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
        int n = prices.length;
        int dp[][] = new int[n+1][2];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(prices,0,1,dp);
    }
}