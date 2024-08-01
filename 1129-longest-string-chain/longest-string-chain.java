class Solution {
    public boolean checkMatching(String word1,String word2){
        // String word1 = words[ind1];
        // String word2 = words[ind2];
        // if(word1.length()==word2.length()){
        //     if(word1.equals(word2))
        //     return true;
        //     else
        //     return false;
        // }
        // else if(word1.length()<word2.length()){
        //     int i = 0;
        //     int j = 0;
        //     while(j<word2.length() && i<word1.length()){
        //         if(word1.charAt(i)==word2.charAt(j)){
        //             i++;
        //             j++;
        //         }
        //         else
        //         j++;
        //     }
        //     if(i==word1.length())
        //     return true;
        //     else
        //     return false;
        // }
        // else{
        //     int i = 0;
        //     int j = 0;
        //     while(i<word1.length() && j<word2.length()){
        //         if(word1.charAt(i)==word2.charAt(j)){
        //             i++;
        //             j++;
        //         }
        //         else
        //         j++;
        //     }
        //     if(i==word2.length())
        //     return true;
        //     else
        //     return false;
        if (word1.length() + 1 != word2.length()) {
            return false;
        }
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            if (word1.charAt(i) == word2.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == word1.length();
    }
    public int helper(String words[],int index,int n,int dp[]){
        if(index==n)
        return 0;
        int max = 1;
        // int take = 0;
        // int notTake= 0 ;
        if(dp[index]!=-1)
        return dp[index];
        for(int i = index+1;i<n;i++){
            if(checkMatching(words[index],words[i])){
                max = Math.max(max,1 + helper(words,i,n,dp));
            }
        }
        return dp[index] = max;
    }
    public int longestStrChain(String[] words) {
        // Arrays.sort(words);
        // for(String w:words){
        //     System.out.println(w);
        // }
        // return 0;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int n = words.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<words.length;i++){
            max = Math.max(max,helper(words,i,n,dp));
        }
        return max;

    }
}