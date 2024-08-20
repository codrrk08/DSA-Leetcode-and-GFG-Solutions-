class Solution {
    public String reverseWords(String s) {
        // s = s.trim();
        // s = s.replaceAll("\\s+"," ");
        // System.out.println(s);
        // // StringBuilder sb = new StringBuilder(s);
        // StringBuilder ans = new StringBuilder();
        // String temp = "";
        // for(int i = 0;i<s.length();i++){
        //     char ch = s.charAt(i);
        //     if(ch!=' '){
        //         temp+=ch;
        //     }
        //     else{
        //         ans.insert(0," ");
        //         ans.insert(1,temp);
        //         temp="";
        //     }
            
        // }
        // ans.insert(0,temp);
        // return ans.toString();
        String[] words = s.trim().split("\\s+");
        StringBuilder ans = new StringBuilder();

        for(int i = words.length - 1; i >= 0; i--){
            ans.append(words[i]);
            if(i != 0){
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}