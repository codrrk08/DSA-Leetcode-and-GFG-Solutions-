class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(char ch:s.toCharArray()){
            sb.append(ch-'a'+1);
        }
        // double num = Double.parseDouble(sb.toString());
        // System.out.println(num);
        // int sum = 0;
        // for(int i = 0;i<k;i++){
        //     while(num!=0){
        //         sum+=num%10;
        //         num = num/(int)10;
        //     }
        //     num = sum;
        //     if(sum<10)
        //     break;
        //     sum =0;
        // }
        // return (int)num;
        String str = sb.toString();
        for(int i = 0;i<k;i++){
            int sum = 0;
            for(char ch:str.toCharArray()){
                sum+=ch-'0';
            }
            str = String.valueOf(sum);
        }
        return Integer.parseInt(str);
    }
}