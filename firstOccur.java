class Solution {
    public int strStr(String haystack, String needle) {
        int i=0,j;
        String ch="";
        while(i<=(haystack.length()-needle.length()))
        {
            j=i;
            while(j<needle.length()+i)
            {
                ch = ch+ haystack.charAt(j);
                j++;
            }
            if(ch.equals(needle))
            return (i);
            else
            {
                ch="";
                i++;
            }
        
        }
        return -1;
    
        
    }
}
