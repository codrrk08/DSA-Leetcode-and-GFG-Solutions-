class Solution {
    // public int helper(int prices[],int index,int canBuy,int count,int dp[][][]){
    //     if(index==prices.length)
    //     return 0;
        
    //     if(count==2)
    //     return 0; 

    //     if(dp[index][canBuy][count]!=-1)
    //     return dp[index][canBuy][count];
    //     int profit=0;
    //     if(canBuy==1){
    //         profit = Math.max(-prices[index] + helper(prices,index+1,0,count,dp),helper(prices,index+1,1,count,dp));
    //     }
    //     else{
    //         profit = Math.max(prices[index] + helper(prices,index+1,1,count+1,dp),helper(prices,index+1,0,count,dp));
    //     }
    //     return dp[index][canBuy][count] = profit;
    // }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n+1][2][3];
        // for(int row[][]:dp){
        //     for(int r[]:row){
        //         Arrays.fill(r,-1);
        //     }
        // }
        // dp[n][0][0] = 0;
        // dp[n][0][1] = 0;
        // dp[n][1][0] = 0;
        // dp[n][1][1] = 0;

        // for(int i=0;i<=n;i++){
        //     for(int j = 0;j<=1;j++){
        //         dp[i][j][2] = 0;
        //     }
        // }
        for(int i = n-1;i>=0;i--){
            for(int j = 0;j<=1;j++){
                for(int k = 1;k<=2;k++){
                    int profit = 0;
                    if(j==1){
                        dp[i][j][k]= Math.max(-prices[i] + dp[i+1][0][k],dp[i+1][1][k]);
                    }
                    else
                    dp[i][j][k] = Math.max(prices[i] + dp[i+1][1][k-1],dp[i+1][0][k]);
                    
                }
            }
        }

        // return helper(prices,0,1,0,dp);
        return dp[0][1][2];
    }
}