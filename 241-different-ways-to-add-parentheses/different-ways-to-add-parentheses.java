class Solution {
    // public static String findAnswer(String exp,int ind,String curr,List<Integer> ans){
    //     if(curr.length()==1){
    //         return curr;
    //     }

    //     for(int i = ind;i<exp.length();i++){
    //         char ch = exp.charAt(i);
    //         int res = 0;
    //         int f =0;
    //         if(ch=='*'){
    //             res = Integer.parseInt(findAnswer(exp,i,exp.substring(0,i),ans)) * 
    //             Integer.parseInt(findAnswer(exp,i,exp.substring(i+1),ans));
    //             f=1;
    //         }
    //         else if(ch=='+'){
    //             res = Integer.parseInt(findAnswer(exp,i,exp.substring(0,i),ans)) +
    //             Integer.parseInt(findAnswer(exp,i,exp.substring(i+1),ans));
    //             f=1;
    //         }
    //         else if(ch=='-'){
    //             res = Integer.parseInt(findAnswer(exp,i,exp.substring(0,i),ans)) -
    //             Integer.parseInt(findAnswer(exp,i,exp.substring(i+1),ans));
    //             f=1;
    //         }
    //         if(f==1)
    //         ans.add(res);
    //     }

    //     return curr;
    // }
    public List<Integer> findAnswer(String expression) {
        List<Integer> result = new ArrayList<>();
        
        // Loop through the expression
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            // If we encounter an operator
            if (c == '+' || c == '-' || c == '*') {
                // Recursively evaluate the left and right sides
                List<Integer> leftPart = findAnswer(expression.substring(0, i));
                List<Integer> rightPart = findAnswer(expression.substring(i + 1));
                
                // Combine the results of left and right parts
                for (int left : leftPart) {
                    for (int right : rightPart) {
                        if (c == '+') {
                            result.add(left + right);
                        } else if (c == '-') {
                            result.add(left - right);
                        } else if (c == '*') {
                            result.add(left * right);
                        }
                    }
                }
            }
        }
        
        // Base case: if the result is empty, it means the expression is a number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        
        return result;
    }
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        ans = findAnswer(expression);
        return ans;
    }
}