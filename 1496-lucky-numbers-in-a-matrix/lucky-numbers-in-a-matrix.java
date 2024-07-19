class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> listMin = new ArrayList<>();
        for(int i = 0;i<matrix.length;i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0;j<matrix[0].length;j++){
                min = Math.min(matrix[i][j],min);
            }
            listMin.add(min);
        }
        List<Integer> listMax = new ArrayList<>();

        for(int i = 0;i<matrix[0].length;i++){
            int max = 0;
            for(int j = 0;j<matrix.length;j++){
                max = Math.max(matrix[j][i],max);
            }
            listMax.add(max);
        }
        int maxele = 0;
        for(int num:listMin){
            maxele = Math.max(num,maxele);
        }
        int minele = Integer.MAX_VALUE;
        for(int num:listMax){
            minele = Math.min(num,minele);
        }
        List<Integer> ans = new ArrayList<>();
        if(minele==maxele)
        ans.add(minele);
        return ans;

        

        
    }
}