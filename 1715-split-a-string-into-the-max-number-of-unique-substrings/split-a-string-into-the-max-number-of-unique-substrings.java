class Solution {
    int max = 0;
    public void findAnswer(String s,int index,HashSet<String> hs){
        if(index>=s.length())
        return;

        for(int i = index;i<s.length();i++){
            String temp = s.substring(index,i+1);
            if(!hs.contains(temp)){
                hs.add(temp);
                max = Math.max(max,hs.size());
                findAnswer(s,index+temp.length(),hs);
                hs.remove(temp);
            }
        }

        return;

    }
    public int maxUniqueSplit(String s) {
        HashSet<String> hs = new HashSet<>();
        findAnswer(s,0,hs);
        return max;
    }
}