class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sumMN = mean*(n+rolls.length);
        int sumM = 0;

        for(int x:rolls){
            sumM+=x;
        }
        if(sumMN<sumM)
        return new int[]{};
        int sumN = sumMN-sumM;
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
        if(sumN>0)
        return new int[]{};
        else
        return ans;
    }
}