class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer,String> hm = new HashMap<>();
        int len = heights.length;
        for(int i = 0; i<len; i++){
            hm.put(heights[i],names[i]);
        }
        Arrays.sort(heights);
        for(int j = len-1; j>=0; j--){
            names[len-1-j] = hm.get(heights[j]);
        }
        return names;

        
    }
}