class Solution {
    class Pair{
        int first;
        int second;
        int dist;
        public Pair(int f,int s, int dist){
            this.first = f;
            this.second = s;
            this.dist = dist;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int vis[][] = new int[n][m];
        int ans[][] = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j]==0){
                    q.offer(new Pair(i,j,0));
                    vis[i][j] = 1;
                }
                else{ 
                    vis[i][j] = 0;
                }
            }
        }

        int delRow[] = {-1,1,0,0};
        int delCol[] = {0,0,-1,1};
        // for(int row[]:vis){
        //     Arrays.fill(row,0);
        // }
        while(!q.isEmpty()){
            int i = q.peek().first;
            int j = q.peek().second;
            int d = q.peek().dist;
            // vis[i][j] = 1;
            ans[i][j] = d;
            q.poll();
            for(int k = 0;k<4;k++){
                int nrow = i + delRow[k];
                int ncol = j + delCol[k];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0){
                    vis[nrow][ncol]=1;
                    q.offer(new Pair(nrow,ncol,d+1));
                }
            }
        }
        return ans;
    }
}