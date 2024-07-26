class Solution {
    public int helper(int amt,int []coins,int index,int dp[][]){
        if(amt==0)
        return 1;
        if(index==0){
            if(amt%coins[0]==0)
            return 1;
            else
            return 0;
        }

        if(dp[index][amt]!=-1)
        return dp[index][amt];
        int notTake = helper(amt,coins,index-1,dp);
        int take = 0;
        if(coins[index]<=amt){
            take = helper(amt-coins[index],coins,index,dp);
        }

        return dp[index][amt] = (take+notTake);
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(amount,coins,n-1,dp);
    }
}