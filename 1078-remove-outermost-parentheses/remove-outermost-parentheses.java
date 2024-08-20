class Solution {
    public String removeOuterParentheses(String s) {
       StringBuilder sb = new StringBuilder(s);
       StringBuilder ans = new StringBuilder();
       int countOpen = 0;
       for(int i = 0;i<s.length();i++){
            char ch = sb.charAt(i);
            if(ch=='('){
                if(countOpen>0)
                ans.append('(');
                countOpen++;
            }
            else{
                countOpen--;
                if(countOpen>0)
                ans.append(')');
            }
       }
       return ans.toString();
    }
}