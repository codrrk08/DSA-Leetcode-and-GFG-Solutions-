class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    
        List<List<Integer>> listOfLists = new ArrayList<>();
        Arrays.sort(nums); // sort the array to simplify the solution
        for (int i = 0; i < nums.length - 2; i++) { // iterate over all possible first elements
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) { // avoid duplicates
                int left = i + 1; // initialize the left pointer
                int right = nums.length - 1; // initialize the right pointer
                while (left < right) { // iterate over all possible second and third elements
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) { // found a triplet
                        listOfLists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left+1]) left++; // avoid duplicates
                        while (left < right && nums[right] == nums[right-1]) right--; // avoid duplicates
                        left++; // move the left pointer forward
                        right--; // move the right pointer backward
                    } else if (sum < 0) {
                        left++; // move the left pointer forward
                    } else {
                        right--; // move the right pointer backward
                    }
                }
            }
        }
        return listOfLists;
    }
}
