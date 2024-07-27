class Solution {
    // public int helper(String s1,String s2,int ind1,int ind2,int dp[][]){
    //     if(ind1==0 || ind2==0)
    //     return 0;
        
    //     if(dp[ind1][ind2]!=-1)
    //     return dp[ind1][ind2];
    //     if(s1.charAt(ind1-1)==s2.charAt(ind2-1)){
    //         return 1 + helper(s1,s2,ind1-1,ind2-1,dp);
    //     }
    //     return dp[ind1][ind2] = Math.max(helper(s1,s2,ind1-1,ind2,dp),helper(s1,s2,ind1,ind2-1,dp));
    // }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n+1][m+1];
        // for(int row[]:dp){
        //     Arrays.fill(row,-1);
        // }
        //handling the i==0 condition
        for(int j = 0;j<=m;j++){
            dp[0][j] = 0;
        }
        //handling the j==0 condition
        for(int i = 0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
}