class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Stack<Integer> st = new Stack<>();
        int boats = 0;
        Arrays.sort(people);
        for(int i=people.length-1;i>=0;i--){
            if(people[i]==limit){
                boats++;
                continue;
            }
            if((!st.isEmpty()) && (st.peek()+people[i])<=limit){
                st.pop();
                boats++;
            }
            else
            st.push(people[i]);
        }
        return boats+st.size();
        
    }
}