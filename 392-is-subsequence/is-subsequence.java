class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int indexS = 0;
        int f=0;
        if(s.length()==0)
        return true;
        for(int i = 0;i<t.length();i++){
            char ch = t.charAt(i);
            if(ch==s.charAt(indexS)){
                indexS++;
                if(indexS==s.length()){
                    f=1;
                    break;
                }
            }
        }
        if(f==1)
        return true;
        else
        return false;
    }
}