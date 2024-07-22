class Solution {
    public int helper(int grid[][],int m,int n,int i,int j,int dp[][]){
        if(i==m-1 && j==n-1)
        return grid[i][j];
        
        if(i>m-1 || j>n-1)
        return (int)1000000;
        
        if(dp[i][j]!=-1)
        return dp[i][j];
        int down= grid[i][j] + helper(grid,m,n,i+1,j,dp);
        int right= grid[i][j] + helper(grid,m,n,i,j+1,dp);
       
        return dp[i][j] = Math.min(down,right);
        
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m+1][n+1];
        for(int row[]:dp)
        Arrays.fill(row,-1);
        return helper(grid,m,n,0,0,dp);
    }
}