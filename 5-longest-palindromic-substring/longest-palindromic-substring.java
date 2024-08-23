class Solution {
    public boolean isPalindrome(int i,int j,String s){
        if(j-i<3){
            return s.charAt(i)==s.charAt(j);
        }
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
            return false;
            i++;
            j--;
        }
        return true;
    }
    // public String solve(String s,int left,int right,boolean dp[][]){
    //     if (left > right) {
    //         return "";
    //     }

    //     // Base case: if left equals right, it's a single character palindrome
    //     if (left == right) {
    //         return s.substring(left, left + 1);
    //     }

    //     // Check if the current substring is a palindrome
    //     if (s.charAt(left) == s.charAt(right)) {
    //         String potentialPalindrome = s.substring(left, right + 1);
    //         if (isPalindrome(potentialPalindrome)) {
    //             return potentialPalindrome;
    //         }
    //     }

    //     // Recursively check for the longest palindrome in the substrings excluding either left or right character
    //     String palindrome1 = solve(s, left + 1, right);
    //     String palindrome2 = solve(s, left, right - 1);

    //     // Return the longer of the two palindromes found
    //     return palindrome1.length() > palindrome2.length() ? palindrome1 : palindrome2;
    // }
    public String longestPalindrome(String s) {
        // if (s == null || s.length() < 2) {
        //     return s;
            
        // }
        // int n = s.length();
        // boolean dp[][] = new boolean[n][n];
        // // for(int row[]:dp){
        // //     Arrays.fill(row,-1);
        // // }

        // return solve(s, 0, s.length() - 1,dp);
        int n = s.length();
        String ans = "";
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                // if(j-i+1<ans.length())
                // continue;
                if(isPalindrome(i,j,s)){
                    if(j-i+1>ans.length()){
                        ans = s.substring(i,j+1);
                    }
                }
            }
        }
        return ans;
    }
}