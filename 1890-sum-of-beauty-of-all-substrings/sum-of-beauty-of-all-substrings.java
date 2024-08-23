class Solution {
    public int beautySum(String s) {
        int sum = 0;
        // int arr[] = new int[26]; //array of alphabets
        int n = s.length();
        for(int i = 0;i<n;i++){
            int arr[] = new int[26]; 
            for(int j = i;j<n;j++){
                int ch = s.charAt(j);
                arr[ch-'a']++;
                int min = Integer.MAX_VALUE;
                int max = 0;
                for(int f:arr){
                    if(f>0){
                        min = Math.min(min,f);
                        max = Math.max(max,f);
                    }
                }
                sum+=max-min;
            }
        }
        return sum;
    }
}