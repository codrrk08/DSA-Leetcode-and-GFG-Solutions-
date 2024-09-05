class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sumMN = mean*(n+rolls.length);
        int sumM = 0;

        for(int x:rolls){
            sumM+=x;
        }
        int sumN = sumMN-sumM;

        if(sumN<n || sumN>n*6)
        return new int[]{};
        
        int i = 0;
        int ans[] = new int[n];
        
        while(n>0){
            int pos = sumN/n;
            if(pos>6 || pos==0)
            return new int[]{};
            ans[i] = pos;
            sumN-=pos;
            i++;
            n--;
        }
        // if(sumN>0)
        // return new int[]{};
        // else
        return ans;
    }
}