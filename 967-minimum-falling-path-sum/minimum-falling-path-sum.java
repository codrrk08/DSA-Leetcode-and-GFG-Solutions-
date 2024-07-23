class Solution {
    public int helper(int matrix[][],int n,int i,int j,int dp[][]){
        if(j<0 || j>n-1)
        return (int)1e8;
        if(i==n-1)
        return matrix[i][j];

        if(dp[i][j]!=-Integer.MIN_VALUE)
        return dp[i][j];
        int min = Integer.MAX_VALUE;
        
        int down = matrix[i][j] + helper(matrix,n,i+1,j,dp);
        int lDiag = matrix[i][j] + helper(matrix,n,i+1,j-1,dp);
        int rDiag = matrix[i][j] + helper(matrix,n,i+1,j+1,dp);
        min = Math.min(down,Math.min(lDiag,rDiag));

        return dp[i][j] = min;
    }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        // int ans = 0
        int min = Integer.MAX_VALUE;
        int dp[][] = new int[n+1][n+1];
        for(int row[]:dp){
            Arrays.fill(row,Integer.MIN_VALUE);
        }
        for(int i = 0;i<n;i++){
            int ans = helper(matrix,n,0,i,dp);
            min = Math.min(min,ans);
            for(int row[]:dp){
                Arrays.fill(row,Integer.MIN_VALUE);
            }
        }
        return min;

    }
}