class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 1;i<=n;i++){
            ans.add(i);
        }
        // Collections.sort(ans, new Comparator<Integer>() {
        //     // @Override
        //     public int compare(Integer num1, Integer num2) {
        //         // Convert the integers to strings for lexicographical comparison
        //         String str1 = num1.toString();
        //         String str2 = num2.toString();
        //         return str1.compareTo(str2); // Lexicographical comparison
        //     }
        // });
        Collections.sort(ans,(a,b)->{
            String s1 = Integer.toString(a);
            String s2 = Integer.toString(b);
            return s1.compareTo(s2);
        });
        return ans;
    }
}