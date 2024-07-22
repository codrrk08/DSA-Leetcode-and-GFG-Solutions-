class Solution {
    public int helper(int m,int n,int i,int j,int grid[][],int dp[][]){
        if(i==m-1 && j==n-1)
        return 1;
         
        if(dp[i][j]!=-1)
        return dp[i][j];
        int down = 0;
        int right = 0;
        if(i<m-1 && grid[i+1][j]!=1)
            down=down+helper(m,n,i+1,j,grid,dp);
        if(j<n-1 && grid[i][j+1]!=1)
            right=right+ helper(m,n,i,j+1,grid,dp);

        return dp[i][j]=down+right;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        if(obstacleGrid[m-1][n-1]==1 || obstacleGrid[0][0]==1)
        return 0;
        return helper(m,n,0,0,obstacleGrid,dp);
        
    }
}