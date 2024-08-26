class Solution {
    public String minWindow(String s, String t) {
    // int n = s.length();
    // int m = t.length();
    // HashMap<Character, Integer> map = new HashMap<>();

    // int count = 0;
    // int start = -1;
    // int min = Integer.MAX_VALUE;

    // int l = 0;
    // int r = 0;

    // for (int i = 0; i < m; i++)
    // map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);

    // while (r < n) {
    // if (map.getOrDefault(s.charAt(r), 0) > 0) {
    // count++;
    // map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) - 1);
    // }
    // while (count == m) {
    // if (r - l + 1 < min) {
    // min = r - l + 1;
    // start = l;
    // }

    // map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
    // if (map.get(s.charAt(l)) > 0)
    // count--;

    // l++;
    // }

    // r++;
    // }

    // if (start == -1)
    // return "";
    // return s.substring(start, start + min);

    // }
    int n = s.length();
    int m = t.length();
    HashMap<Character, Integer> map = new HashMap<>();

    // Populate the map with the frequency of characters in t
    for(int i = 0;i<m;i++)
    {
        map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
    }

    int count = 0; // To track how many characters have been matched
    int start = -1; // To track the starting index of the minimum window
    int min = Integer.MAX_VALUE; // To track the length of the minimum window
    int l = 0; // Left pointer
    int r = 0; // Right pointer

    while(r<n)
    {
        char rightChar = s.charAt(r);

        // If the character exists in t, decrease its frequency in the map
        if (map.containsKey(rightChar)) {
            map.put(rightChar, map.get(rightChar) - 1);
            // If the frequency becomes 0, it means we've matched all instances of this
            // character
            if (map.get(rightChar) >= 0) {
                count++;
            }
        }

        // Try to shrink the window when we have a valid window with all characters
        // matched
        while (count == m) {
            // Update the minimum window
            if (r - l + 1 < min) {
                min = r - l + 1;
                start = l;
            }

            char leftChar = s.charAt(l);
            if (map.containsKey(leftChar)) {
                map.put(leftChar, map.get(leftChar) + 1);
                // If the frequency becomes positive, it means removing this character broke the
                // match
                if (map.get(leftChar) > 0) {
                    count--;
                }
            }

            l++;
        }

        r++;
    }

    return(start==-1)?"":s.substring(start,start+min);
}
}