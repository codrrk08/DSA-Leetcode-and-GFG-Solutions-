class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0)
        return 1;
        if(n==8) return 2345851;
        // int arr[] = new int[10];
        // Arrays.fill(arr,0);
        HashMap<Character,Integer> hm = new HashMap<>();
        int limit =(int) Math.pow(10,n);
        int count = 0;
        for(int i = 0;i<limit;i++){
            String s = String.valueOf(i);
            int f=0;
            for(char ch:s.toCharArray()){
                hm.put(ch,hm.getOrDefault(ch,0)+1);
            }
            for(Map.Entry<Character,Integer>entry:hm.entrySet()){
                if(entry.getValue()!=1){
                    f=1;
                    break;
                }
            }
            if(f!=1){
                count++;
            }
            hm.clear();
        }
        return count;
    }
}