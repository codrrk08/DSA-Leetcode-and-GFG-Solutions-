class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> hs = new HashSet<>(dictionary);
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>(Arrays.asList(sentence.split(" ")));
        for (String word : list) {
            int index = 0;
            while (index <= word.length()) {
                String w = word.substring(0, index);
                if (hs.contains(w)) {
                    sb.append(w);
                    sb.append(" ");
                    break;
                }
                index++;
            }
            if (index == word.length() + 1) {
                sb.append(word);
                sb.append(" ");
            }

        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
// for(char ch:sentence.toCharArray()){
// if(ch==' '){
// list.add(w);
// w="";
// }
// else
// w = w+ch;

// }
// list.add(w);
// // System.out.println(list);

// for(String word:list){
// String item = "";
// for(char ch:word.toCharArray()){
// item = item+ch;
// if(dictionary.contains(item)){
// sentence=sentence.replaceFirst(word,item);
// // System.out.println("in here");
// break;
// }
// }
// }
// return sentence;
// sentence=sentence+" ";
// String ans = "";
// String w ="";
// int f=0;
// for(int i =0;i<sentence.length();i++){
// char ch = sentence.charAt(i);
// if(ch!=' '){
// w = w+ch;
// if(dictionary.contains(w)){
// // ans = ans+w+" ";
// while(sentence.charAt(i)!=' '){
// i++;
// }
// }
// }
// else if(sentence.charAt(i)==' '){
// ans+=w+" ";
// w="";
// // f=0;
// }

// }
// return ans.trim();
