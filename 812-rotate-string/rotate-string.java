class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.equals(goal))
        return true;
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        while(count!=s.length()-1){
            char ch = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(ch);
            if(sb.toString().equals(goal))
            return true;
            count++;
        }
        return false;
    }
}