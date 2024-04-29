class Solution {
public:
    int minOperations(vector<int>& nums, int k) {
        int final = 0;
        
        for (int n : nums) {
            final = final ^ n;
        }
        
        int count = 0;
        
        while (k > 0 || final > 0) {
            
            if ((k % 2) != (final % 2)) {
                count++;
            }
            
            
            k /= 2;
            final /= 2;
        }
        
        return count;
        
    }
};