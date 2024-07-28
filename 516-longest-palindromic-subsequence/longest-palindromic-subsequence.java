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
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(s,rev,n-1,n-1,dp);
    }

}