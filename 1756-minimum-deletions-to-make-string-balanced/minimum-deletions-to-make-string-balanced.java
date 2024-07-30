class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> st = new Stack<>();
        int del = 0;
        // int count = 0;
        // for(int i = 0;i<s.length();i++){
        //     if(s.charAt(i)=='b')
        //     count++;
        // }
        // if(count==s.length())
        // return 0;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);

            if(!st.isEmpty() && st.peek()=='b' && ch=='a'){
                del++;
                st.pop();
            }
            else 
            st.push(ch);
        }
        return del;
    }
}