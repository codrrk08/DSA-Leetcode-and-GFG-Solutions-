class Solution {
    public int helper(String s,int k,int index,int prev,int dp[][]){
        if(index==s.length())
        return 1;

        int take = 0;
        if(dp[index][prev]!=-1)
        return dp[index][prev];
        if(Math.abs(s.charAt(index)-(prev+'a'))<=k){
            return  dp[index][prev] = Math.max(1 + helper(s, k, index+1,s.charAt(index)-'a',dp),helper(s,k,index+1,prev,dp)) ;
        }
        return  dp[index][prev] = helper(s,k,index+1,prev,dp);

        // return Math.max(take,notTake);
    }
    public int longestIdealString(String s, int k) {
        if(s.length()==1)
        return 1;
        int max = Integer.MIN_VALUE;
        int n = s.length();


        int dp[][] = new int[n+1][26];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        for(int i =0;i<s.length()-1;i++){
            max = Math.max(max,helper(s,k,i+1,s.charAt(i)-'a',dp));
        }
        return max;    
    }
}