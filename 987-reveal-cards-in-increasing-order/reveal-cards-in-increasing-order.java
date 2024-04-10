class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<deck.length;i++){
            q.add(i);
        }
        int ans[] = new int[deck.length];
        for(int i = 0;i<deck.length;i++){
            int front = q.poll();
            ans[front] = deck[i];
            if(!q.isEmpty()){
                int temp = q.poll();
                q.add(temp);
            }
            else
            break;
        }
        return ans;
        
    }
}