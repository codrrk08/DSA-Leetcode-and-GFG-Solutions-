class Solution {
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<score.length;i++){
            hm.put(score[i],i);
        }
        int len = score.length;
        Arrays.sort(score);
        String ans[] = new String[len];
        for(int i=len-1;i>=0;i--){
            if(i==len-1)
            ans[hm.get(score[i])]="Gold Medal";
            else if(i==len-2){
                ans[hm.get(score[i])]="Silver Medal";
            } 
            else if(i==len-3){
                ans[hm.get(score[i])]="Bronze Medal";
            }
            else{
                ans[hm.get(score[i])]=String.valueOf(len-i);
            }
        }
        return ans;
    }
}