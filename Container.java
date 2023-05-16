class Solution {
    public int maxArea(int[] height) {
        int left= 0;
        int right=height.length-1;
        int ans=0,area=0;
        // Two-pointer approach
        while(left<right)
        {
            area =Math.min(height[left],height[right]) * (right-left);
            ans = Math.max(ans,area);
            if(height[left]<height[right])
            left++;
            else if(height[left]==height[right])
            {
                left++;
                right--;
            }
            else
            right--;
        }
        return ans;
        
    }
}
