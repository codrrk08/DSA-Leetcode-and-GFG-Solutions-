class Solution {
    public boolean isPalindrome(int x) {
        int rev=0;int c=x;
        while(x!=0)
        {
            if(x<0)
            return false;
            else
            {
            rev=rev*10+x%10;
            x=x/10;
            }
            
        }
        if(c==rev)
        return true;
        else
        return false;
        
    }
}
