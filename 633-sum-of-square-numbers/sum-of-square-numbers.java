class Solution {
    public boolean judgeSquareSum(int c) {
        int half =(int) Math.sqrt(c);
        int arr[] = new int[half+1];
        for(int i = 0;i<arr.length;i++){
            arr[i] = i;
        }
        // for(int i = 0;i<arr.length;i++){
        //     if(arr[i]*arr[i]+arr[i+1]*arr[i+1]==c)
        // }
        // System.out.println(Arrays.toString(arr));
        HashMap<Integer,Integer> hm =new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            hm.put(arr[i]*arr[i],arr[i]);
        }
        boolean result = false;
        for(int i = 0;i<arr.length;i++){
            if(hm.containsKey(c-(arr[i]*arr[i])))
            return true;
        }
        return result;
        
    }
}