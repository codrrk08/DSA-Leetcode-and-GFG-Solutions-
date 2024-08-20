class Solution {
    public String removeOuterParentheses(String s) {
    //    StringBuilder sb = new StringBuilder(s);
    //    StringBuilder ans = new StringBuilder();
    //    int countOpen = 0;
    //    for(int i = 0;i<s.length();i++){
    //         char ch = sb.charAt(i);
    //         if(ch=='('){
    //             if(countOpen>0)
    //             ans.append('(');
    //             countOpen++;
    //         }
    //         else{
    //             countOpen--;
    //             if(countOpen>0)
    //             ans.append(')');
    //         }
    //    }
    //    return ans.toString();
        Stack<Character> openBracket = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(openBracket.size()>0){
                    sb.append(s.charAt(i));
                }
                openBracket.push(s.charAt(i));
            }else{
                openBracket.pop();
                if(openBracket.size()>0){
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
    }
}