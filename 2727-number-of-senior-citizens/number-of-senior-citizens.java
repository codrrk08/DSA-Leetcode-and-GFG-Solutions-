class Solution {
    public int countSeniors(String[] details) {
        int n = details.length;
        int count = 0;
        for(String str:details){
            // int index = str.length()-1;
            // while(!Character.isLetter(str.charAt(index))){
            //     index--;
            // }
            int age = Integer.parseInt(str.substring(11,13));
            if(age>60)
            count++;
        }
        return count;
    }
}