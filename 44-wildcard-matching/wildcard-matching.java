class Solution {
    // public boolean helper(String s,String p,int i,int j,int dp[][]){
    //     if(i==0 && j==0)
    //     return true;
    //     if(j==0 && i>0)
    //     return false;
    //     if(j>0 && i==0){
    //         for(int x = 1;x<=j;x++){
    //             if(p.charAt(x-1)!='*')
    //             return false;
    //         }
    //         return true;
    //     }
    //     if(dp[i][j]!=-1)
    //     return (dp[i][j]==0)?false:true;
    //     boolean ans = false;
    //     if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
    //         ans = helper(s,p,i-1,j-1,dp);
    //         dp[i][j] = (ans==true)?1:0;
    //         return ans;
    //     }
    //     else if(p.charAt(j-1)=='*'){
    //         ans = helper(s,p,i,j-1,dp) || helper(s,p,i-1,j,dp) ; 
    //         dp[i][j] = (ans==true)?1:0;
    //     }
    //     else{
    //         dp[i][j] = 0;
    //         return false;
    //     }
    //     return ans;
    // }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean dp[][] = new boolean[n+1][m+1];
        // for(int row[]:dp){
        //     Arrays.fill(row,-1);
        // }
        dp[0][0] = true;
        for(int i = 1;i<=n;i++){
            dp[i][0] = false;
        }
        int flag =0;
        for(int j = 1;j<=m;j++){
            for(int x = 1;x<=j;x++){
                if(p.charAt(x-1)!='*'){
                    flag=1;
                    break;
                }
            }
            if(flag==1)
            dp[0][j] = false;
            else
            dp[0][j] = true;
        }
        
        for(int i = 1;i<=n;i++){
            for(int j =1;j<=m;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?')
                    dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1)=='*')
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                else
                    dp[i][j] = false;
            }
        }
        return dp[n][m];
    }
}