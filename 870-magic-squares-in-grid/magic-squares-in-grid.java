// class Solution {
//     public boolean isMagicSquare(int [][]grid,int row,int col){
//         boolean[] seen = new boolean[10];
//         for(int i = row;i<row+3;i++){
//             for(int j = col;j<col+3;j++){
//                 int num = grid[i][j];
//                 if(num<1 || num>9 || seen[num])
//                 return false;
//                 seen[num] = true;
//             }
//         }

//         int sum = grid[row][col] + grid[row][col+1] + grid[row][col+2]; 

//         //check rows
//         for(int i = row;i<row+3;i++){
//             if(grid[i][col] + grid[i][col+1] + grid[row][col+2] !=sum){
//                 return false;
//             }
//         }

//         //check columns
//         for (int j = col; j < col + 3; j++) {
//             if (grid[row][j] + grid[row + 1][j] + grid[row + 2][j] != sum) {
//                 return false;
//             }
//         }

//         // Check diagonals
//         if (grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2] != sum) {
//             return false;
//         }
//         if (grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col] != sum) {
//             return false;
//         }

//         return true;
//     }
//     public int numMagicSquaresInside(int[][] grid) {
//         int row = grid.length;
//         int col = grid[0].length;
//         // boolean seen[] = new boolean[10];
//         int count = 0;
//         for(int i = 0;i<row-3;i++){
//             for(int j = 0;j<col-3;j++){
//                 // int num = grid[i][j];
//                 if(isMagicSquare(grid,i,j))
//                 count++;
//                 // seen[num] = true;
//             }
//         }
//         return count;
//     }
// }
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // Iterate through each possible 3x3 subgrid
        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isMagicSquare(int[][] grid, int rowStart, int colStart) {
        // Check if the 3x3 grid contains all numbers from 1 to 9
        boolean[] seen = new boolean[10];
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                int num = grid[i][j];
                if (num < 1 || num > 9 || seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }

        // Calculate the sum of the first row
        int sum = grid[rowStart][colStart] + grid[rowStart][colStart + 1] + grid[rowStart][colStart + 2];

        // Check rows
        for (int i = rowStart; i < rowStart + 3; i++) {
            if (grid[i][colStart] + grid[i][colStart + 1] + grid[i][colStart + 2] != sum) {
                return false;
            }
        }

        // Check columns
        for (int j = colStart; j < colStart + 3; j++) {
            if (grid[rowStart][j] + grid[rowStart + 1][j] + grid[rowStart + 2][j] != sum) {
                return false;
            }
        }

        // Check diagonals
        if (grid[rowStart][colStart] + grid[rowStart + 1][colStart + 1] + grid[rowStart + 2][colStart + 2] != sum) {
            return false;
        }
        if (grid[rowStart][colStart + 2] + grid[rowStart + 1][colStart + 1] + grid[rowStart + 2][colStart] != sum) {
            return false;
        }

        return true;
    }
}