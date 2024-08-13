class Solution {
//     // List<List<Integer>> ans = new ArrayList<>();
//     // public void helper(int []candidates,HashSet<List<Integer>> hs,int target,List<Integer> list,int index){
//     //     // if(target<0)
//     //     // return;
//     //     // if(target==0){
//     //     //     hs.add(new ArrayList<>(list));
//     //     //     return;
//     //     // }
//     //     if(index==candidates.length){
//     //         if(target==0){
//     //             hs.add(new ArrayList<>(list));
//     //         }
//     //         return;
//     //     }
//     //     if(candidates[index]<=target){
//     //         list.add(candidates[index]);
//     //         helper(candidates,hs,target-candidates[index],list,index+1);
//     //         list.remove(list.size()-1);
//     //     }
//     //     helper(candidates,hs,target,list,index+1);
        
//     // }
    public static void helper(int index,int [] arr,int target,List<List<Integer>> ans,List<Integer> list){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = index;i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1])
            continue;
            if(arr[i]>target)
            break;

            list.add(arr[i]);
            helper(i+1,arr,target-arr[i],ans,list);
            list.remove(list.size()-1);
        }
    }
    // public static void helper2(int prev,int i,int []arr,int target,HashSet<List<Integer>> ans,List<Integer> curr){
    //     if(i==arr.length){
    //         if(target==0)
    //         ans.add(new ArrayList<>(curr));
    //         return;
    //     }

    //     if(arr[i]<=target ){
    //         curr.add(arr[i]);
    //         helper2(i,i+1,arr,target-arr[i],ans,curr);
    //         curr.remove(curr.size()-1);
    //     }

    //     helper2(prev,i+1,arr,target,ans,curr);
    //     return;

    // }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Arrays.sort(candidates);
        // HashSet<List<Integer>> hs = new HashSet<>();
        // helper(candidates,hs,target,list,0);
        // for(List<Integer> l:hs){
        //     ans.add(l);
        // }
        // return ans;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0,candidates,target,ans,new ArrayList<>());
        // int n = candidates.length;
        // for(int i = 0;i<candidates.length;i++){
        //     helper2(i-1,i,candidates,target,ans,new ArrayList<>(),dp);
        // }
        // List<List<Integer>> l = new ArrayList<>(ans);
        return ans;
        
        
    }
}
// class Solution {
//     public static void sum(int[] arr, int ind, int target, List<List<Integer>> list, List<Integer> ds){
//       if(target==0){
//           list.add(new ArrayList<>(ds));
//        return;
//       }
//       for(int i=ind; i<arr.length;i++){
//           if(i>ind && arr[i]==arr[i-1])continue;
//           if(arr[i]>target)break;
        
//         ds.add(arr[i]);
//         sum(arr,i+1,target-arr[i],list,ds);
//         ds.remove(ds.size()-1);
//       }
//     }
//     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//         List<List<Integer>> ans= new ArrayList<>();
//         Arrays.sort(candidates);
//         sum(candidates,0,target,ans,new ArrayList<>());
//         return ans;
//     }
// }