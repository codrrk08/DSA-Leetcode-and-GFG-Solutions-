// class Solution {
//     public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
//         TreeMap<Integer,Integer> hm = new TreeMap<>();
//         for(int i = 0;i<profits.length;i++){
//             if(!hm.containsKey(capital[i])){
//                 hm.put(capital[i],profits[i]);
//             }
//             else
//             hm.put(capital[i],Math.max(hm.get(capital[i]),profits[i]));
//         }
//         int maxCapital = w;
//         ArrayList<Integer> list = new ArrayList<>(hm.keySet());
//         // System.out.println(list);
//         for(int i = 0;i<list.size() && k>0;i++){
//             if(i==0 && list.get(i)>maxCapital)
//             break;
//             if(list.get(i)<maxCapital && i!=list.size()-1){
//                 continue;
//             }
//             else if(list.get(i)>maxCapital && k>0 ){
//                 if(maxCapital>=list.get(i-1))
//                 break;
//                 maxCapital+=hm.get(list.get(i-1));
//                 k--;
//             }
//             else{
//                 maxCapital+=hm.get(list.get(i));
//                 k--;
//             }
//         }
//         // for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
//         //     if(entry.getKey()<=maxCapital && k>0){
//         //         maxCapital+=entry.getValue();
//         //         k--;
//         //     }
//         // }
//         return maxCapital;

        
//     }
// }
class Solution {
    // Defining the Project class within the Solution class
    private static class Project {
        int capital;
        int profit;

        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<Project> projects = new ArrayList<>();

        // Creating list of projects with capital and profits
        for (int i = 0; i < n; i++) {
            projects.add(new Project(capital[i], profits[i]));
        }

        // Sorting projects by capital required
        Collections.sort(projects, (a, b) -> a.capital - b.capital);

        // Max-heap to store profits (using a min-heap with inverted values)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);
        int i = 0;

        // Main loop to select up to k projects
        for (int j = 0; j < k; j++) {
            // Add all profitable projects that we can afford
            while (i < n && projects.get(i).capital <= w) {
                maxHeap.add(projects.get(i).profit);
                i++;
            }

            // If no projects can be funded, break out of the loop
            if (maxHeap.isEmpty()) {
                break;
            }

            // Otherwise, take the project with the maximum profit
            w += maxHeap.poll();
        }

        return w;
    }
}