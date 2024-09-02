class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        int i = 0;
        while(chalk[i]<=k){
            k-=chalk[i];
            if(i==n-1)
            i=0;
            else
            i++;
        }
        return i;
    }
}