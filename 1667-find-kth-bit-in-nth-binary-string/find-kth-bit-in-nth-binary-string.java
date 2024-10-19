class Solution {
    public char findKthBit(int n, int k) {
        if(n==1)
        return '0';
    
        StringBuilder sb = new StringBuilder();
        sb.append('0');
        for (int i = 2; i <= n; i++) {
            StringBuilder temp = new StringBuilder(sb);       
            for (int j = 0; j < temp.length(); j++) {
                char bit = temp.charAt(j);
                temp.setCharAt(j, bit == '0' ? '1' : '0');
            }   
            temp.reverse();
            sb.append('1').append(temp);
        }

        return sb.charAt(k-1);
    }
}