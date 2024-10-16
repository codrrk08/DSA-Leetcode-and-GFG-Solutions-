class Solution {
    // public String longestDiverseString(int a, int b, int c) {
    // PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(y[1],
    // x[1]));
    // if(a!=0)
    // pq.offer(new int[]{97,a});
    // if(b!=0)
    // pq.offer(new int[]{98,b});
    // if(c!=0)
    // pq.offer(new int[]{99,c});

    // StringBuilder sb = new StringBuilder();
    // int second[] = pq.poll();
    // while(true){
    // // int temp[] = pq.poll();
    // int ch = second[0];
    // int count = second[1];
    // int k=1;
    // while(k<=2 && count>0){
    // sb.append((char)ch);
    // count--;
    // k++;
    // }
    // // int second[];
    // if(!pq.isEmpty())
    // second = pq.poll();
    // else
    // break;
    // if(count!=0)
    // pq.offer(new int[]{ch,count});
    // }
    // return sb.toString();

    // }
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(y[1], x[1]));
        
        // Add the counts for 'a', 'b', and 'c' if they are greater than 0
        if (a > 0) pq.offer(new int[]{'a', a});
        if (b > 0) pq.offer(new int[]{'b', b});
        if (c > 0) pq.offer(new int[]{'c', c});

        StringBuilder sb = new StringBuilder();

        // While there are still characters in the priority queue
        while (!pq.isEmpty()) {
            // Get the character with the most remaining frequency
            int[] first = pq.poll();

            // If the last two characters are the same as the current character, we need to add a different character
            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == first[0] && sb.charAt(sb.length() - 2) == first[0]) { 
                // If there's no other character to add, we're done
                if (pq.isEmpty()) {
                    break;
                }
                
                // Get the second-highest character
                int[] second = pq.poll();
                sb.append((char) second[0]);
                second[1]--;

                // Re-add the second character back to the queue if it still has remaining count
                if (second[1] > 0) {
                    pq.offer(second);
                }

                // Put the first character back into the queue for the next iteration
                pq.offer(first);
            } 
            else {
                // Otherwise, append the current highest frequency character
                sb.append((char) first[0]);
                first[1]--;
                
                // If there's still remaining count for this character, re-add it to the queue
                if (first[1] > 0) {
                    pq.offer(first);
                }
            }
        }
        
        return sb.toString();
    }

}