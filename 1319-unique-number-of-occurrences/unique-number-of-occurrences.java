class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // HashMap to store <num,occurences>
        Map<Integer, Integer> map = new HashMap<>();

        
        // if the key exists, increment its value; if not, start with 1.
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // Use a set to store the frequenceies
        Set<Integer> occurences = new HashSet<>();


        for(int freq : map.values()){

            // If the frequency is already in the set, return false
            if(!occurences.add(freq)){
                return false;
            }

        }
                
        return true;
    }
}