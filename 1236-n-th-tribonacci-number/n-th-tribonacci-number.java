class Solution {
    public int tribonacci(int n) {
        // if(n==0)
        // return 0;
        // else if(n==1 || n==2)
        // return 1;
        // else
        // return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
        int a = 0;
        int b = 1;
        int c = 1;
        int ans = 0;
        if(n==0)
        return 0;
        if(n==1 || n==2)
        return 1;
        for(int i = 3; i<=n;i++){
            ans = a+b+c;
            a = b;
            b = c;
            c = ans;
        }
        return ans;
        
    }
}