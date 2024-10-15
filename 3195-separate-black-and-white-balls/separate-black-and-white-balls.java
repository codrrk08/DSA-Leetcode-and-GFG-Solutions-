class Solution {
    public long minimumSteps(String s) {
        long sum = 0;
        int i =0 ;
        long countZero = 0;
        long countOne = 0;
        while(i<=s.length()){
            if(i==s.length()){
                sum+=countZero*countOne;
                break;
            }
            char ch = s.charAt(i);
            if(ch=='1'){
                sum+=countZero*countOne;
                countZero = 0;
                countOne++;
            }
            else if(ch=='0' && i!=0){
                countZero++;
            }
            i++;
        }
        return sum;
    }
}