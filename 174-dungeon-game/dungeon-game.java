class Solution {
    public void findAnswer(PriorityQueue<Integer> pq,int[][] dungeon,int i,int j,int n,int m,int sum){
        if(i==n-1 && j==m-1){
            sum+=dungeon[i][j];
            if(sum<=0){
                pq.offer(Math.abs(sum)+1);
            }
            else
            pq.offer(sum);
        }
        if(i>=n || j>=m)
        return;

        sum+=dungeon[i][j];
        findAnswer(pq,dungeon,i+1,j,n,m,sum);
        findAnswer(pq,dungeon,i,j+1,n,m,sum);
        sum-=dungeon[i][j];

        return;
        

    }
    public int calculateMinimumHP(int[][] dungeon) {
        // List<Integer> ans = new ArrayList<>();
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // int n = dungeon.length;
        // int m = dungeon[0].length;
        // if(n==1 && m==1){
        //     if(dungeon[0][0]<=0)
        //     return Math.abs(dungeon[0][0])+1;
        //     else
        //     return 1;
        // }
        // findAnswer(pq,dungeon,0,0,n,m,0);
        // return pq.poll();
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        // dp[i][j] represents the minimum health required to reach the bottom-right
        // corner starting from cell (i, j)
        int[][] dp = new int[m + 1][n + 1];
        
        // Initialize the dp array with maximum values
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        // Base case: Minimum health required at bottom-right cell
        dp[m][n - 1] = 1;
        dp[m - 1][n] = 1;
        
        // Fill the dp array from bottom-right to top-left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int minHealthRequired = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = (minHealthRequired <= 0) ? 1 : minHealthRequired;
            }
        }
        
        return dp[0][0];
    }
}