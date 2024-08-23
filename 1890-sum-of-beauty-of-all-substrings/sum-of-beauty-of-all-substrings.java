class Solution {
    public int beautySum(String s) {
        int sum = 0;
        // int arr[] = new int[26]; //array of alphabets
        int n = s.length();
        int dp[][] = new int[n][n];
        for(int i = n-1;i>=0;i--){
            HashMap<Character,Integer> hm = new HashMap<>();
            for(int j = i;j<n;j++){
                char ch = s.charAt(j);
                hm.put(ch,hm.getOrDefault(ch,0)+1);
                int min = Integer.MAX_VALUE;
                int max = 0;
                for(int val:hm.values()){
                    if(val>0){
                        min = Math.min(min,val);
                        max = Math.max(max,val);
                    }
                }
                sum+=max-min;
            }
        }
        return sum;
    }
}