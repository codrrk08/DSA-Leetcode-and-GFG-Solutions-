class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]","");
        String rev="";
        int i = s.length()-1;
        while(i>=0)
        {
            rev= rev+ s.charAt(i);
            i--;
        }
        if(s.equals(rev))
        return true;
        else
        return false;
        
        
    }
}
