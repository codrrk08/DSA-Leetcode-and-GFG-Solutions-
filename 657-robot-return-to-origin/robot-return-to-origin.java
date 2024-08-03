class Solution {
    public boolean judgeCircle(String moves) {
        HashMap<Character,Integer> hm = new HashMap<>();
        // hm.put('U',0);
        // hm.put('D',0);
        // hm.put('L',0);
        // hm.put('R',0);
        int u = 0;
        int d = 0;
        int l = 0;
        int r = 0;
        for(int i = 0;i<moves.length();i++){
            char ch = moves.charAt(i);
            // hm.put(ch,hm.getOrDefault(ch,0)+1);
            if(ch=='U')
            u++;
            else if(ch=='D')
            d++;
            else if(ch=='L')
            l++;
            else
            r++;
        }
        // if(hm.get('U')==hm.get('D') && hm.get('L')==hm.get('R'))
        // return true;
        // else
        // return false;
        if(u==d && l==r)
        return true;
        else
        return false;
    }
}