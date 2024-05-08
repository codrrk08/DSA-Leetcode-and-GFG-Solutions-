class Solution {
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<score.length;i++){
            hm.put(score[i],i);
        }
        Arrays.sort(score);
        String ans[] = new String[score.length];
        for(int i=score.length-1;i>=0;i--){
            if(i==score.length-1)
            ans[hm.get(score[i])]="Gold Medal";
            else if(i==score.length-2){
                ans[hm.get(score[i])]="Silver Medal";
            } 
            else if(i==score.length-3){
                ans[hm.get(score[i])]="Bronze Medal";
            }
            else{
                ans[hm.get(score[i])]=String.valueOf(score.length-i);
            }
        }
        return ans;
    }
}