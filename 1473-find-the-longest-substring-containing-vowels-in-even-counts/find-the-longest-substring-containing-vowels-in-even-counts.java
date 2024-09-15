class Solution {
    public int findTheLongestSubstring(String s) {
         HashMap<Integer, Integer> maskMap = new HashMap<>();
        // Initial mask is 0, meaning all vowels have even counts
        maskMap.put(0, -1);
        
        int mask = 0; // Initial bitmask
        int maxlen = 0;
        
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            
            // Update the mask based on the current character
            switch (ch) {
                case 'a': 
                    mask ^= 1 << 0; // Flip the bit for 'a'
                    break;
                case 'e': 
                    mask ^= 1 << 1; // Flip the bit for 'e'
                    break;
                case 'i': 
                    mask ^= 1 << 2; // Flip the bit for 'i'
                    break;
                case 'o': 
                    mask ^= 1 << 3; // Flip the bit for 'o'
                    break;
                case 'u': 
                    mask ^= 1 << 4; // Flip the bit for 'u'
                    break;
            }
            
            // If the current bitmask has been seen before, calculate the max length
            if (maskMap.containsKey(mask)) {
                maxlen = Math.max(maxlen, j - maskMap.get(mask));
            } else {
                // If seeing this mask for the first time, store the index
                maskMap.put(mask, j);
            }
        }
        
        return maxlen;

    }
}