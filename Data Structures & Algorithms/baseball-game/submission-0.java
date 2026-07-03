class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack= new Stack<>();
        
        for(String op: operations){
            if(op.equals("+")){
                int top = stack.pop();
                int newtop = top+stack.peek();
                stack.push(top);
                stack.push(newtop);
            }
            else if(op.equals("D")){
                stack.push(2*stack.peek());
            }
            else if(op.equals("C")){
                stack.pop();
            }
            else{
                stack.push(Integer.parseInt(op));
            }
            
        }
        int sum =0;
        for(int score:stack){
            sum += score;
        }
        return sum;
        
    }
}