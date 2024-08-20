class Solution {
    public String longestCommonPrefix(String[] strs) {
        // LinkedHashMap<Character,Integer> lhm = new LinkedHashMap<>();
        // for(char ch:strs[0]){
        //     lhm.put(ch,lhm.getOrDefault(ch,0)+1);
        // }
        int len = (int)1e9;
        int index = 0;
        for(int i = 0;i<strs.length;i++){
            if(strs[i].length()<len){
                len = strs[i].length();
                index = i;
            }
        }
        int check[] = new int[len];
        for(int i = 0;i<strs[index].length();i++){
            check[i] = strs[index].charAt(i);
        }
        // StringBuilder sb = new StringBuilder();
        int minLen = (int)1e9;
        String ans = strs[index];
        for(int i= 0;i<strs.length;i++){
            if(i==index)
            continue;
            char s[] = strs[i].toCharArray();
            int l = 0;
            for(int j = 0;j<s.length;j++){
                if(j<check.length && check[j]==s[j])
                l++;
                else{
                    if(l<minLen){
                        ans = strs[i].substring(0,j);
                        minLen = l;
                    }
                }
            }
        }
        return ans;
    }
}