class Solution {
    public int helper(int coins[],int amt,int index,int dp[][]){
        if(index==0){
            if(amt%coins[0]==0)
            return amt/coins[0];
            else
            return (int)1e8;
        }
        if(dp[index][amt]!=-1)
        return dp[index][amt];
        int notTake = 0 + helper(coins,amt,index-1,dp);
        int take = (int)1e8;
        if(coins[index]<=amt){
            take = 1 + helper(coins,amt-coins[index],index,dp);
        }
        
        // min = Math.min(min,(take+notTake));
        // notTake = helper(coins,amt,index-1);

        return dp[index][amt] = Math.min(take,notTake);

    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(amount==0)
        return 0;
        if(n==1 && amount%coins[0]!=0)
        return -1;
        if(n==1)
        return amount/coins[0];
        int dp[][] = new int[n+1][amount+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        int ans = helper(coins,amount,n-1,dp);
        return (ans==(int)1e8)?-1:ans;
    }
}