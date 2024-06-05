// class Solution {
//     public List<String> commonChars(String[] words) {
//         int minfreq[] = new int[26];
//         Arrays.fill(minfreq,Integer.MAX_VALUE);
//         for(String word:words){
//             int[] charCount = new int[26];
//             for(char ch:word.toCharArray()){
//                 charCount[ch-'a']++;
//             }
//             for(int j=1;j<26;j++){
//                 minfreq[j] = Math.min(minfreq[j],charCount[j]);
//             }
//         }
//         List<String> list = new ArrayList<>();
//         for(int i = 0;i<26;i++){
//             while (minfreq[i]-- > 0) {
//                 list.add(Character.toString((char) (i + 'a')));
//                 // minfreq[i]--;
//             }
//         }
//         return list;
//     }
// }
class Solution {
    public List<String> commonChars(String[] words) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);
        
        for (String word : words) {
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }
        
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (minFreq[i]-- > 0) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }
        return result;
    }
}