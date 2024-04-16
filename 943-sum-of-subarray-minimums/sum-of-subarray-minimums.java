class Solution {
    public int sumSubarrayMins(int[] arr) {
        // long sum = 0;
        // // int mod = 1000000007;
        // for(int i = 0; i<arr.length;i++){
        // // long max = arr[i];
        // int min = arr[i];
        // int res = 0;
        // for(int j = i; j<arr.length;j++){
        // // max = Math.max(max,arr[j]);
        // min = Math.min(min,arr[j]);
        // res+= min;
        // }
        // sum+=res%1000000007;
        // }
        // return (int)sum;
        long res = 0;

        for (int i = 0; i < arr.length; i++) {
            res = (res + minsumsubarray(arr, i)) % 1000000007;
        }
        return (int) res;
    }

    public int minsumsubarray(int[] a, int s) {

        int minv = a[s];
        int result = 0;

        for (int i = s; i < a.length; i++) {
            minv = Math.min(minv, a[i]);
            result += minv;
        }
        return result;
    }
}