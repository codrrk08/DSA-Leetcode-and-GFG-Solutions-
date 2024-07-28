class Solution {
    public int helper(String s,String t,int i,int j,int dp[][]){
        if(j==0){
            return 1;
        }
        if(i==0)
        return 0;

        if(dp[i][j]!=-1)
        return dp[i][j];
        int countMatch = 0;int countNotMatch = 0;
        if(s.charAt(i-1)==t.charAt(j-1)){
            countMatch = helper(s,t,i-1,j-1,dp) + helper(s,t,i-1,j,dp);
        }
        else
        countNotMatch = helper(s,t,i-1,j,dp);

        return dp[i][j] = (countMatch + countNotMatch);
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n+1][m+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(s,t,n,m,dp);
    }
}