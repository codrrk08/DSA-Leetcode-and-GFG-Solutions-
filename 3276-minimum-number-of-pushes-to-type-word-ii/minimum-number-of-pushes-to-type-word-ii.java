import java.util.*;
class Solution {
    public int minimumPushes(String word) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=  0;i<word.length();i++){
            char ch = word.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        Collection l = hm.values();
        ArrayList<Integer> list = new ArrayList<>(l);
        Collections.sort(list);
        System.out.println(list);
        int count = 8;
        int ans = 0;
        int mul = 1;
        int flag = 0;
        for(int i = list.size()-1;i>=0;i--){
            count--;
            if(count<0){
                mul++;
                flag++;
                if(flag!=3)
                count = 7;
                else
                count=1;
            }
            ans+=list.get(i)*mul;
        }
        return ans;
    }
}