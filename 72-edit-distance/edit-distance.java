class Solution {
    public int helper(String s,String t,int i,int j,int dp[][]){
        if(i<0)
        return j+1;
        if(j<0)
        return i+1;

        if(dp[i][j]!=-1)
        return dp[i][j];
        if(s.charAt(i)!=t.charAt(j)){
            return dp[i][j] = 1 + Math.min(helper(s,t,i-1,j,dp),Math.min(helper(s,t,i,j-1,dp),helper(s,t,i-1,j-1,dp)));
        }
        return dp[i][j] = helper(s,t,i-1,j-1,dp);
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n+1][m+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }

        return helper(word1,word2,n-1,m-1,dp);

    }
}