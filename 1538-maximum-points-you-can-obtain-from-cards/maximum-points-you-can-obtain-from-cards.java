class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int suml = 0;
        int sumr = 0;
        for(int i = 0; i<k;i++){
            suml+=cardPoints[i];
        }
        int maxSum = suml;
        int rindex = cardPoints.length-1;
        for(int i = k-1;i>=0;i--){
            suml-=cardPoints[i];
            sumr+=cardPoints[rindex];
            rindex--;
            maxSum = Math.max(maxSum,suml+sumr);
        }
        return maxSum;
        
    }
}