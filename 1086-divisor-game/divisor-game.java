class Solution {
    public boolean divisorGame(int n) {
        int count = 0;
        while(n!=1){
            count++;
            n = n-1;
        }
        return (count%2==0)?false:true;
    }
}