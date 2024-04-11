class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if(len==1)
        return "0";
        StringBuilder sb = new StringBuilder(num);
        int f=0;
        while(k!=0){
            for(int i = 0;i<sb.length();i++){
                if(i==sb.length()-1){
                    f=1;
                    break;
                }
                if(sb.charAt(i)>sb.charAt(i+1)){
                    sb.deleteCharAt(i);
                    k--;
                    break;
                }
            }
            if(f==1)
            break;
        }
        if(f==1){
            while(k!=0){
                sb.deleteCharAt(sb.length()-1);
                k--;
            }
        }
        
        while(sb.length()!=0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        if(sb.length()==0){
            sb.append('0');
        }
        return sb.toString();

        
    }
}