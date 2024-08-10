class Solution {
    class Pair{
        String word;
        int len;
        public Pair(String w,int l){
            this.word = w;
            this.len = l;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs = new HashSet<>();
        for(String s:wordList){
            hs.add(s);
        }
        if(!hs.contains(endWord))
        return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord,1));
        if(hs.contains(beginWord))
        hs.remove(beginWord);

        while(!q.isEmpty()){
            String word = q.peek().word;
            int l = q.peek().len;
            q.poll();

            if (word.equals(endWord) == true) return l;

            for(int i = 0;i<word.length();i++){
                for(char j = 'a';j<='z';j++){
                    StringBuilder sb = new StringBuilder(word);
                    sb.setCharAt(i,j);

                    if(hs.contains(sb.toString())){
                        q.offer(new Pair(sb.toString(),l+1));
                        hs.remove(sb.toString());
                    }
                    
                }
            }
        }
        return 0;
        
    }
}