class Solution {
    public int helper(String s1,String s2,int ind1,int ind2,int dp[][]){
        if(ind1==0 || ind2==0)
        return 0;
        
        if(dp[ind1][ind2]!=-1)
        return dp[ind1][ind2];
        if(s1.charAt(ind1-1)==s2.charAt(ind2-1)){
            return 1 + helper(s1,s2,ind1-1,ind2-1,dp);
        }
        return dp[ind1][ind2] = Math.max(helper(s1,s2,ind1-1,ind2,dp),helper(s1,s2,ind1,ind2-1,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[][] = new int[m+1][n+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(text1,text2,m,n,dp);
    }
}