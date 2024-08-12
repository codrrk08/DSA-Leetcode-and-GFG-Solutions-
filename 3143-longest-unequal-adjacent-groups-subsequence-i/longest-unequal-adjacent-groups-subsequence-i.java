class Solution {
    // class Pair{
    //     String s;
    //     int index;
    //     public Pair(String st,int ind){
    //         this.s = st;
    //         this.index = ind;
    //     }
    // }
    public void helper(String []words,int groups[],int prev,int index, List<String> current, List<String> result){
        if(index==groups.length){
            if (current.size() > result.size()) {
                result.clear();
                result.addAll(current);
            }
            return;
        }
        if(prev==-1 || groups[prev]!=groups[index]){
            current.add(words[index]);
            helper(words,groups,index,index+1,current,result);
            current.remove(current.size()-1);
        }
        helper(words,groups,prev,index+1,current,result);

        return;

    }
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        // List<String> result = new ArrayList<>();
        // // List<String> current = new ArrayList<>();
        // helper(words, groups, -1, 0, new ArrayList<>(), result);
        // return result;
        // List<String> ans = new ArrayList<>();
        // for(int i = 0;i<words.length;i++){
        //     int prev = -1;
        //     List<String> curr = new ArrayList<>();
        //     for(int j =i ;j<words.length;j++){
        //         if(prev==-1)
        //         curr.add(words[i]);
        //         else if(groups[prev]!=groups[j]){
        //             curr.add(words[j]);
        //         }
        //         prev = j;
        //     }
        //     if(curr.size()>ans.size()){
        //         ans.clear();
        //         ans.addAll(curr);
        //     }
        // }
        // return ans;List<String> ans = new ArrayList<>();
        int n = words.length;
        List<String> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(i == 0 || groups[i] != groups[i-1]){
                ans.add(words[i]);
            }
        }

        return ans;
        
    }
}