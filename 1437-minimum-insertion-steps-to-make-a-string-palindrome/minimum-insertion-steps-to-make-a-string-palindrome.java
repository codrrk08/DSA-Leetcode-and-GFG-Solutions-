class Solution {
    public int helper(String s,String rev,int i,int j,int dp[][]){
        if(i==0 || j==0)
        return 0;

        if(dp[i][j]!=-1)
        return dp[i][j];
        if(s.charAt(i-1)==rev.charAt(j-1))
        return 1 + helper(s,rev,i-1,j-1,dp);

        return dp[i][j] = Math.max(helper(s,rev,i,j-1,dp),helper(s,rev,i-1,j,dp));
    }
    public int minInsertions(String s) {
        String rev="";
        for(int i = 0;i<s.length();i++){
            rev = s.charAt(i) + rev;
        }
        int n = s.length();
        int dp[][] = new int[n+1][n+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return n-helper(s,rev,n,n,dp);
        
    }
}