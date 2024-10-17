class Solution {
    public int maximumSwap(int num) {
        String s = Integer.toString(num);
        char arr[] = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(char ch:arr){
            sb.append(ch);
        }
        sb.reverse();
        if(sb.toString().equals(s)){
            return num;
        }
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            hm.put(ch,i);
        }
        int index = -1;
        int i = 0;
        for(i = 0;i<sb.length();i++){
            if(sb.charAt(i)==s.charAt(i)){
                continue;
            }
            else{
                index = hm.get(sb.charAt(i));
                break;
            }
        }
        System.out.println(sb.toString());
        StringBuilder sb2 = new StringBuilder(s);
        char c1 = s.charAt(i);
        char c2 = sb.charAt(i);
        sb2.setCharAt(i,c2);
        sb2.setCharAt(index,c1);
        return Integer.parseInt(sb2.toString());
        // return 0;
    }
}