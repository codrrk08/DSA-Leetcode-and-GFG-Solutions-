class Solution {
    public boolean isHappy(int n) {

        int i=1;
        int newNum=0;
        if(n==1)
        return true;
        else if(n>1&&n<=4)
        return false;
        while(n!=0)
        {
            int d = n%10;
            newNum = newNum+ d*d;
            n=n/10;
        }
        return isHappy(newNum);

}}
