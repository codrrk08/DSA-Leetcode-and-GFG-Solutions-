class Solution {
    public int helper(int m,int n,int i,int j,int dp[][]){
        if(i==m-1 && j==n-1)
        return 1;

        if(dp[i][j]!=-1)
        return dp[i][j];
        int left = 0;
        int right = 0;
        if(i<m-1)
        left = left+helper(m,n,i+1,j,dp);

        if(j<n-1)
        right = right+helper(m,n,i,j+1,dp);

        return dp[i][j] = left + right;
    }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return helper(m,n,0,0,dp);

    }
}