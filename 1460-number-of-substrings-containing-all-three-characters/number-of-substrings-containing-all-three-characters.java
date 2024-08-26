class Solution {
    public int numberOfSubstrings(String s) {
        // HashMap<Character,Integer> hm = new HashMap<>();
        // int count = 0;
        // int len = s.length();
        // for(int i = 0;i<len;i++){
        // char ch = s.charAt(i);
        // hm.put(ch,i);
        // if(hm.size()==3){
        // count+= 1 + Collections.min(hm.values());
        // }
        // }
        // return count;
        // int chars[] = new int[3];
        // Arrays.fill(chars, -1);
        // int count = 0;
        // for (int i = 0; i < s.length(); i++) {
        //     chars[s.charAt(i) - 'a'] = i;
        //     if (chars[0] != -1 && chars[1] != -1 && chars[2] != -1){
        //         count += 1 + Math.min(Math.min(chars[0], chars[1]), chars[2]);
        //     }
        // }
        // return count;
        HashMap<Character,Integer> hm = new HashMap<>();
        int count = 0;
        int len = s.length();
        int i = 0;
        int j = 0;
        while(j<len){
            char ch = s.charAt(j);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            while(hm.size()==3){
                count+= len-j;
                hm.put(s.charAt(i),hm.get(s.charAt(i))-1);
                if(hm.get(s.charAt(i))==0)
                hm.remove(s.charAt(i));
                i++;
            }
            j++;
        }
        return count;
        

    }
}