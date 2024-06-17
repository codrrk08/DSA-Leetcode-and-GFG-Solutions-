class Solution {
    public boolean judgeSquareSum(int c) {
        // int half =(int) Math.sqrt(c);
        // int arr[] = new int[half+1];
        // for(int i = 0;i<arr.length;i++){
        //     arr[i] = i;
        // }
        // HashMap<Integer,Integer> hm =new HashMap<>();
        // for(int i = 0;i<arr.length;i++){
        //     hm.put(arr[i]*arr[i],arr[i]);
        // }
        // boolean result = false;
        // for(int i = 0;i<arr.length;i++){
        //     if(hm.containsKey(c-(arr[i]*arr[i])))
        //     return true;
        // }
        // return result;
        long half =(long) Math.sqrt(c);
        long i = 0;
        long j = half;
        while(i<=j){
            if(i*i+j*j==c)
            return true;
            else if(i*i+j*j>c)
            j--;
            else
            i++;
        }
        return false;
        
    }
}