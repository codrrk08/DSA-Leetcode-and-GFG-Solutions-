class Solution {
    public int decreasing(int arr[], int index, int len, int dp2[][]) {
        if (len == 3)
            return 1;
        if (index < 0)
            return 0;

        if (dp2[index][len] != -1)
            return dp2[index][len];
        int pick = 0;
        for (int i = index - 1; i >= 0; i--) {
            if (arr[i] > arr[index])
                pick += decreasing(arr, i, len + 1, dp2);
        }
        return dp2[index][len] = pick;
    }

    public int increasing(int arr[], int index, int len, int dp1[][]) {

        if (len == 3)
            return 1;
        if (index < 0)
            return 0;

        if (dp1[index][len] != -1)
            return dp1[index][len];
        int pick = 0;
        for (int i = index - 1; i >= 0; i--) {
            if (arr[i] < arr[index])
                pick += increasing(arr, i, len + 1,dp1);
        }
        return dp1[index][len] = pick;
    }

    public int numTeams(int[] rating) {
        int n = rating.length;
        int ans = 0;
        int dp1[][] = new int[n][4];
        for(int row[]:dp1){
            Arrays.fill(row,-1);
        }
        int dp2[][] = new int[n][4];
        for(int row[]:dp2){
            Arrays.fill(row,-1);
        }
        for(int i = n-1;i>=0;i--){
            ans += increasing(rating,i,1,dp1) + decreasing(rating,i,1,dp2);
        }
        return ans;
    }
}