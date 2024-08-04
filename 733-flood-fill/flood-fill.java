class Solution {
    // class Pair{
    //     int row;
    //     int col;
    //     int time;
    //     Pair(int r,int c,int t){
    //         this.row = r;
    //         this.col = c;
    //         this.time = t;
    //     }
    // }
    public void helper(int[][]image,int i,int j,int color,int n,int m,int ini){
        if(i<0 || i>=n || j<0 ||j>=m || image[i][j]==color || image[i][j]!=ini)
        return;

        image[i][j] = color;
        helper(image,i-1,j,color,n,m,ini);
        helper(image,i+1,j,color,n,m,ini);
        helper(image,i,j-1,color,n,m,ini);
        helper(image,i,j+1,color,n,m,ini);

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        helper(image,sr,sc,color,n,m,image[sr][sc]);
        return image;
    }
}