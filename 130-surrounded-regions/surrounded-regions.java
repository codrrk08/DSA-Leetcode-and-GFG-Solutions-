class Solution {
    public void dfs(char board[][],int vis[][],int i,int j){
        if(i<0 || j<0 || i==board.length || j==board[0].length || vis[i][j]==1 || board[i][j]=='X')
        return;

        vis[i][j] = 1;
        dfs(board,vis,i-1,j);
        dfs(board,vis,i+1,j);
        dfs(board,vis,i,j-1);
        dfs(board,vis,i,j+1);
        return;
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int vis[][] = new int[n][m];
        for(int row[]:vis){
            Arrays.fill(row,0);
        }
        for(int i = 0;i<n;i++){
            if(board[i][0]=='O' && vis[i][0]==0)
            dfs(board,vis,i,0);
            if(board[i][m-1]=='O' && vis[i][m-1]==0)
            dfs(board,vis,i,m-1);
        }
        for(int j = 0;j<m;j++){
            if(board[0][j]=='O' && vis[0][j]==0 )
            dfs(board,vis,0,j);
            if(board[n-1][j]=='O' && vis[n-1][j]==0)
            dfs(board,vis,n-1,j);
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j]=='O' && vis[i][j]!=1)
                board[i][j] = 'X';
            }
        }
        
        for(int row[]:vis){
            for(int x:row){
                System.out.println(x+" ");
            }
        }
    }
}