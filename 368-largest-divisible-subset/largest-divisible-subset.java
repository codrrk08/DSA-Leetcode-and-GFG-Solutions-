class Solution {
    HashSet<List<Integer>> hs = new HashSet<>();
    public void helper(int nums[],int ind,List<Integer> list,int n){

        if(ind==n)
        return;
        // List<Integer> list = new ArrayList<>();
        int f=0;
        list.add(nums[ind]);
        for(int i = 0;i<list.size();i++){
            if(nums[i]%nums[ind]==0 || nums[ind]%nums[i]==0)
            continue;
            else{
                f=1;
                break;
            }
        }
        if(f==0){
            helper(nums,ind+1,list,n);
            hs.add(list);
            list.remove(list.size()-1);
            helper(nums,ind+1,list,n);
            // hs.add(list);
        }
        else{
            list.remove(list.size()-1);
            helper(nums,ind+1,list,n);
        }



        return;
        // helper(nums,ind)
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        // List<Integer> list = new ArrayList<>();
        // Arrays.sort(nums);
        // helper(nums,0,list,n);
        // int max = 0;
        // for(List<Integer> l:hs){
        //     max = Math.max(max,l.size());
        // }
        // for(List<Integer> l:hs){
        //     if(l.size()==max)
        //     return l;
        // }
        // return list;
        Arrays.sort(nums);
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int[] hash=new int[n];
        Arrays.fill(hash,1);
        
        for(int i=0; i<=n-1; i++){
            
            hash[i] = i; // initializing with current index
            for(int prev = 0; prev <=i-1; prev ++){
                
                if(nums[i]%nums[prev]==0 && 1 + dp[prev] > dp[i]){
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
        }
        
        int ans = -1;
        int lastIndex =-1;
        
        for(int i=0; i<=n-1; i++){
            if(dp[i]> ans){
                ans = dp[i];
                lastIndex = i;
            }
        }
        
        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(nums[lastIndex]);
        
        while(hash[lastIndex] != lastIndex){ // till not reach the initialization value
            lastIndex = hash[lastIndex];
            temp.add(nums[lastIndex]);    
        }
        
        Collections.reverse(temp);
        return temp;
    }
}