class Solution {
    public String shortestPalindrome(String s) {
        // int i = 0;
        // int j = s.length()-1;
        // StringBuilder sb = new StringBuilder(s);
        // // StringBuilder sb2 = new StringBuilder();
        // int x = -1;
        // while(i<j){
        //     char ch1 = sb.charAt(i);
        //     char ch2 = sb.charAt(j);
        //     if(ch1==ch2){
        //         // sb2.append(ch1);
        //         i++;
        //         j--;
        //     }
        //     else if(ch1!=ch2){
        //         x=i;
        //         sb.insert(0,ch2);
        //         // System.out.println(i);
        //         // j--;
        //         i++;
        //         // System.out.println(sb.toString());
        //     }
        // }
        // String sub = sb.substring(0,x+1);
        // StringBuilder sb2 = new StringBuilder(sub).reverse();
        // sb.replace(0,x+1,sb2.toString());
        // return sb.toString();
        int length = s.length();
        String reversedString = new StringBuilder(s).reverse().toString();

        // Iterate through the string to find the longest palindromic prefix
        for (int i = 0; i < length; i++) {
            if (
                s.substring(0, length - i).equals(reversedString.substring(i))
            ) {
                return new StringBuilder(reversedString.substring(0, i))
                    .append(s)
                    .toString();
            }
        }
        return "";
    }
}