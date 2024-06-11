class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> hm= new HashMap<>();
        HashMap<Integer,Integer> hm2= new HashMap<>();

        for(int i = 0;i<arr2.length;i++){
            hm.put(arr2[i],i);
        }
        for(int i = 0;i<arr2.length;i++){
            hm2.put(i,arr2[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        int ans[] = new int[arr1.length];
        for(int i = 0;i<arr1.length;i++){
            if(!hm.containsKey(arr1[i])){
                ans[i] = 1001;
                list.add(arr1[i]);
            }
            else
            ans[i] = hm.get(arr1[i]);
        }
        Arrays.sort(ans);
        int k = 0;
        Collections.sort(list);
        for(int i = 0;i<ans.length;i++){
            if(!hm2.containsKey(ans[i])){
                ans[i] = list.get(k);
                k++;
            }
            else
            ans[i] = hm2.get(ans[i]); 
        }
        return ans;

    }
}