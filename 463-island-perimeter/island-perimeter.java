class Solution {
    public int islandPerimeter(int[][] grid) {
        int exposed = 0;
        int r = grid.length;
        int c = grid[0].length;
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                if(grid[i][j]==1){
                    if(i+1 >= grid.length){
                        exposed++;
                    }
                    if(i-1 < 0){
                        exposed++;
                    }
                    if(j+1 >= grid[i].length){
                        exposed++;
                    }
                    if(j-1 < 0){
                        exposed++;
                    }
                    if(i+1 >= 0 && i+1 < grid.length && grid[i+1][j] == 0){
                        exposed++;
                    }
                    if(i-1 >= 0 && i-1 < grid.length && grid[i-1][j] == 0){
                        exposed++;
                    }
                    if(j+1 >= 0 && j+1 < grid[i].length && grid[i][j+1] == 0){
                        exposed++;
                    }
                    if(j-1 >= 0 && j-1 < grid[i].length && grid[i][j-1] == 0){
                        exposed++;
                    }
                }
            }
        }
        return exposed;
        
    }
}