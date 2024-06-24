// class Solution {
//     public int minKBitFlips(int[] nums, int k) {
//         int count = 0;
//         for(int i = 0;i<=nums.length-k;i++){
//             if(nums[i]==0 && nums.length-i>=k){
//                 int j = i;
//                 for(j=i;j<i+k;j++){
//                     if(nums[j]==0)
//                         nums[j]=1;
//                     else
//                         nums[j]=0;
//                 }
//                 count++;
//             }
//         }
//         HashSet<Integer> hs = new HashSet<>();
//         for(int n:nums){
//             hs.add(n);
//         }
//         if(hs.size()==1)
//         return count;
//         else
//             return -1;

        
//     }
// }
class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int flipCount = 0; // Tracks the current number of flips
        int result = 0;    // Tracks the total number of flips performed

        for (int i = 0; i < nums.length; i++) {
            // If the current index is outside the range of the last flip window, adjust flipCount
            if (i >= k && nums[i - k] == -1) {
                flipCount--;
            }
            // If the current bit needs to be flipped to become 1
            if (flipCount % 2 == nums[i]) {
                // If flipping is not possible because the remaining elements are less than k
                if (i + k > nums.length) {
                    return -1;
                }
                // Mark the current position as flipped and update counters
                nums[i] = -1;
                // Increase the flip count
                flipCount++;
                // Increase the result
                result++;
            }
        }

        return result;
    }
}