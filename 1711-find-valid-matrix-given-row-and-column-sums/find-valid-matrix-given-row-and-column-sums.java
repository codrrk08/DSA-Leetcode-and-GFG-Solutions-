class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int arr[][] = new int[rowSum.length][colSum.length];
        for(int i = 0;i<rowSum.length;i++){
            for(int j = 0;j<colSum.length;j++){
                if(rowSum[i]<colSum[j]){
                    arr[i][j] = rowSum[i];
                    colSum[j]-=rowSum[i];
                    rowSum[i]-=rowSum[i];
                }
                else{
                    arr[i][j] = colSum[j];
                    rowSum[i]-=colSum[j];
                    colSum[j]-=colSum[j];
                }
            }
        }
        return arr;
    }
}