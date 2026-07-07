class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        
        int total = 0;

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                total = a + b;
                stack.push(total);
            } 
            else if (tokens[i].equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                total = a * b;
                stack.push(total);
            } 
            else if (tokens[i].equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                total = b - a;
                stack.push(total);
            }
            else if (tokens[i].equals("/") ) {
                int a = stack.pop();
                int b = stack.pop();
                total = b/a;
                stack.push(total);
            } 
            else {
                int num = Integer.parseInt(tokens[i]);
                stack.push(num);
            }
        }
        return stack.pop();
    }
}
