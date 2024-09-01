class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length!=m*n)
        return new int[][]{};
        int ans[][] = new int[m][n];
        int row = 0;
        int col = 0;
        for(int i = 0;i<original.length;i++){
            if(col<=n-1){
                ans[row][col] = original[i];
                col++;
            }
            else if(row<m-1){
                col = 0;
                ans[++row][col] = original[i];
                col++;
                // row++;
            }
            else
            return new int[][]{};
        }
        return ans;
        
    }
}