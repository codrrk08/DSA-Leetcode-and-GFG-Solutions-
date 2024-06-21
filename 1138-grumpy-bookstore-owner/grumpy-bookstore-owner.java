class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int l = 0;
        int r = 1;
        int max=0;
        int index = -1;
        int count = 0;
        for(int i = 0;i<customers.length;i++){
            if(grumpy[i]!=1){
                count+=customers[i];
                customers[i] = 0;
            }
        }
        for(int i = 0;i<=customers.length-minutes;i++){
            int sum = 0;
            for(int j = i;j<i+minutes;j++){
                sum+=customers[j];
            }
            if(sum>max){
                max = Math.max(sum,max);
                // index = i;
            }
        }
        // System.out.println(max);
        // System.out.println(index);
        // System.out.println(count);
        count+=max;
        return count;
        
    }
}