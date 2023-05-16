class Solution {
    public int countEven(int num) {
        int i=2;
        int count=0;
        
        while(i<=num)
        {
            String numb = Integer.toString(i);
            int sum=0;
            for(int j=0;j<numb.length();j++)
            {
                sum=sum+numb.charAt(j)-48;
            }
            if(sum%2==0)
            count++;
            i++;

        }
        return count++;
        

        
    }
}
