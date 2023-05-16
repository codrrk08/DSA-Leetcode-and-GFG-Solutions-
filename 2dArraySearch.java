class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i=0,j=0;
        while(i<m)
        {
            while(j<n)
            {
                if(matrix[i][j]==target)
                return true;
                j++;

            }
            i++;
            j=0;
        }
        return false;
        
    }
}
