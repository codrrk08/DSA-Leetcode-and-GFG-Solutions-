import java.util.*;
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // Step 2: Create two HashMaps for character mappings
        Map<Character, Character> mapStr1ToStr2 = new HashMap<>();
        Map<Character, Character> mapStr2ToStr1 = new HashMap<>();

        // Step 3: Iterate over the strings
        for (int i = 0; i < s.length(); i++) {
            char char1 = s.charAt(i);
            char char2 = t.charAt(i);

            // Check if there is a mapping inconsistency
            if (mapStr1ToStr2.containsKey(char1)) {
                if (mapStr1ToStr2.get(char1) != char2) {
                    return false;
                }
            } else {
                mapStr1ToStr2.put(char1, char2);
            }

            if (mapStr2ToStr1.containsKey(char2)) {
                if (mapStr2ToStr1.get(char2) != char1) {
                    return false;
                }
            } else {
                mapStr2ToStr1.put(char2, char1);
            }
        }

        // Step 4: Return true if no conflicts found
        return true;


    }
}