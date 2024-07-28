class Solution {
    public int helper(String s,String rev,int ind1,int ind2,int dp[][]){
        if(ind1<0 || ind2<0)
        return 0;

        if(dp[ind1][ind2]!=-1)
        return dp[ind1][ind2];
        if(s.charAt(ind1)==rev.charAt(ind2)){
            return 1 + helper(s,rev,ind1-1,ind2-1,dp);
        }
        
        return dp[ind1][ind2] = Math.max(helper(s,rev,ind1,ind2-1,dp),helper(s,rev,ind1-1,ind2,dp));
    }
    public int longestPalindromeSubseq(String s) {
        String rev = "";
        for(int i = 0;i<s.length();i++){
            rev = s.charAt(i) + rev;
        }
        int n = s.length();
        int dp[][] = new int[n+1][n+1];
        // for(int row[]:dp){
        //     Arrays.fill(row,-1);
        // }
        for(int i =0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int j =0;j<=n;j++){
            dp[0][j] = 0;
        }
        int max = 0;
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=n;j++){
                if(s.charAt(i-1)==rev.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[n][n];
    }

}