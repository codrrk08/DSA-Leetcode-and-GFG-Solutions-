class Solution {
    // public int helper(String s,String t,int i,int j){
    //     if(i==0 || j==0){
    //         return 0;
    //     }

    //     if(s.charAt(i)==t.charAt(j))
    //     return 1 + helper(s,t,i-1,j-1);

    //     return Math.max(helper(s,t,i)
    // }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        // return helper(word1,word2,i,j);
        int dp[][] = new int[n+1][m+1];

        for(int i = 0;i<=n;i++)
        dp[i][0] = 0;

        for(int j = 0;j<=m;j++)
        dp[0][j] = 0;
        
        for(int i =1;i<=n;i++){
            for(int j =1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                dp[i][j] = 1 + dp[i-1][j-1];
                else
                dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        int len = dp[n][m];
        // int i = n;
        // int j = m;
        // int index = len-1;
        // String str="";
        // for(int k=1; k<=len;k++){
        //     str +="$"; // dummy string
        // }
        // String str = "";
        // StringBuilder ss= new StringBuilder(s);
        // StringBuilder str2=new StringBuilder(str);
        // while(i>0 && j>0){
        //     if(ss.charAt(i-1)==str2.charAt(j-1)){
        //         str2.setCharAt(index,ss.charAt(i-1)); 
        //         index--;
        //         i--;
        //         j--;
        //     }
        //     else if(ss.charAt(i-1)>s2.charAt(j-1)){
        //         i--;
        //     }
        //     else j--;
        // }
        return word1.length()-len + word2.length()-len;
        


    }
}