class Solution {
    public int helper(int books[][],int currW,int i,int currH,int w,int dp[][]){
        if(i==books.length)
        return currH;

        if(dp[i][currW]!=-1)
        return dp[i][currW];
        int sameShelf = Integer.MAX_VALUE;
        if(books[i][0] + currW<=w)
        sameShelf = helper(books,currW+books[i][0],i+1,Math.max(books[i][1],currH),w,dp);
        int newShelf = currH + helper(books,books[i][0],i+1,books[i][1],w,dp);

        return dp[i][currW] = Math.min(sameShelf,newShelf);
        }
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int dp[][] = new int[n+1][shelfWidth+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(books,0,0,0,shelfWidth,dp);
    }
}