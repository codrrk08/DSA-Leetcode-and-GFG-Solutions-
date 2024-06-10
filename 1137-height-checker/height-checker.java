class Solution {
    public int heightChecker(int[] heights) {

        int arr[] = new int[heights.length];
        int i=0;
        for(int num: heights)
        {
            arr[i]= num;
            i++;
        }
        Arrays.sort(arr);
        int c=0;
        for(i = 0;i<heights.length;i++)
        {
            if(heights[i]!=arr[i])
            c++;
        }
        return c;


        
    }
}
