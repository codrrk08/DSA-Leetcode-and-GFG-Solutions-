class Solution {
    public int helper(int prices[],int index,int canBuy,int count,int dp[][][]){
        if(index==prices.length)
        return 0;
        
        if(count==2)
        return 0; 

        if(dp[index][canBuy][count]!=-1)
        return dp[index][canBuy][count];
        int profit=0;
        if(canBuy==1){
            profit = Math.max(-prices[index] + helper(prices,index+1,0,count,dp),helper(prices,index+1,1,count,dp));
        }
        else{
            profit = Math.max(prices[index] + helper(prices,index+1,1,count+1,dp),helper(prices,index+1,0,count,dp));
        }
        return dp[index][canBuy][count] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n+1][2][2];
        for(int row[][]:dp){
            for(int r[]:row){
                Arrays.fill(r,-1);
            }
        }
        return helper(prices,0,1,0,dp);
    }
}