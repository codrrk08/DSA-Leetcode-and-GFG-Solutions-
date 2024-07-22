class Solution {
    public int helper(List<List<Integer>> lol,int i,int j,int m,int dp[][]){
        if(i==m-1)
        return lol.get(i).get(j);

        if(dp[i][j]!=-1)
        return dp[i][j];
        int down =  lol.get(i).get(j) + helper(lol,i+1,j,m,dp);
        int diag = lol.get(i).get(j)+ helper(lol,i+1,j+1,m,dp);
        
        return dp[i][j] = Math.min(down,diag);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==1)
        return triangle.get(0).get(0);
        int m = triangle.size();
        // int n = triangle.get(0).size();
        int dp[][] = new int[m+1][m+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(triangle,0,0,m,dp);
    }
}