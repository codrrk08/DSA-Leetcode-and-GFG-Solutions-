class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        int index = -1;
        for(int i = 0;i<word.length();i++){
            char letter = word.charAt(i);
            if(letter==ch){
                sb.append(ch);
                sb.reverse();
                index = i;
                break;
            }
            sb.append(letter);
        }
        if(index==-1)
        return word;
        else{
            for(int i = index+1;i<word.length();i++){
                sb.append(word.charAt(i));
            }
            return sb.toString();
        }

        
    }
}