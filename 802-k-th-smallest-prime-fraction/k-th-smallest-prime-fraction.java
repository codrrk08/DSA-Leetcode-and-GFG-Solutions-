class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        // int i,j=0;
        HashMap<Double,int[]> hm = new HashMap<>(); 
        ArrayList<Double> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                double frac = (double)arr[i]/arr[j];
                // System.out.println(frac);
                hm.put(frac,new int[]{arr[i],arr[j]});
                list.add(frac);
            }
        }
        Collections.sort(list);
        return hm.get(list.get(k-1));
        
    }
}