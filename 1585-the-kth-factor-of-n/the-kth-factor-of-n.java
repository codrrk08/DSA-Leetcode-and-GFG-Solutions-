class Solution {
    public int kthFactor(int n, int k) {
        if(n==1)
        return 1;
        ArrayList<Integer> list  =  new ArrayList<>();
        for(int i = 1;i<=n;i++){
            if(n%i==0)
            list.add(i);
        }
        Collections.sort(list);
        if(k<=list.size())
        return list.get(k-1);
        else
        return -1;
    }
}