class Solution{
    public long minimumSteps(String s) {
        long sum = 0;
        long countZero = 0;
        long countOne = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '1') {
                sum += countZero * countOne;
                countZero = 0; 
                countOne++;   
            } else if (ch == '0' && i != 0) {
                countZero++;    
            }
        }
        
        sum += countZero * countOne;

        return sum;
    }
}