class Solution {
    class Pair{
        int row;
        int col;
        int time;
        Pair(int r,int c,int t){
            this.row = r;
            this.col = c;
            this.time = t;
        }
    }
    public int orangesRotting(int[][] grid) {
        if(grid.length==0)
        return 0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        
        int vis[][] = new int[n][m];

        int countFresh = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j,0));
                    vis[i][j] = 2;
                }
                else
                vis[i][j] = 0;

                if(grid[i][j]==1)
                countFresh++;
            }
        }
        if(countFresh==0)
        return 0;
        int time = 0;
        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};
        int ans = 0;
        int count = 0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            ans = Math.max(ans,t);
            q.remove();
            for(int i = 0;i<4;i++){
                int nrow = r+dx[i];
                int ncol = c+dy[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    q.offer(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol] = 2;
                    count++;
                }   
            }
        }
        if(count!=countFresh)
        return -1;

        return ans;
        
    }
}