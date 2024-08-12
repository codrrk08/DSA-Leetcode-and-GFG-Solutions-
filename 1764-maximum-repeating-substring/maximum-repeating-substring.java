class Solution {
    public int helper(String s,String p,int i,int j,int n,int m){
        if(j==m)
        return 1;
        if(i==n)
        return 0;

        int count = 0;
        if(s.charAt(i)==p.charAt(j)){
            count+= helper(s,p,i+1,j+1,n,m);
        }
        if(j==0)
        count+=helper(s,p,i+1,0,n,m);

        return count;
    }
    public int maxRepeating(String sequence, String word) {
        // int m = word.length();
        // int n = sequence.length();

        // int ans = 0;
        // for (int i = 0; i <= n - m; i++) 
        // ans += helper(sequence,word, i, 0, n, m);
        // return ans;
        String repeat = word;
        int count = 0;
        while(sequence.contains(repeat)){
            count++;
            repeat = repeat+word;
        }
        return count;
    }
    
}