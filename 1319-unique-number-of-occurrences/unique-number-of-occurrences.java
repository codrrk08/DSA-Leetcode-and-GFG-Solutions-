class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int x:arr){
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        List<Integer> list = new ArrayList<>(hm.values());
        HashMap<Integer,Integer> hm2 = new HashMap<>();
        for(int x:list){
            hm2.put(x,hm2.getOrDefault(x,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:hm2.entrySet()){
            if(entry.getValue()>1)
            return false;
        }
        return true;
    }
}