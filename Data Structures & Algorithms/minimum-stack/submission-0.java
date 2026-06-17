class MinStack {
     Stack<Integer> stack;
     Stack<Integer> minstack;


    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
        
    }
    
    public void push(int value) {
        stack.push(value);
        if(minstack.isEmpty()|| value<= minstack.peek()){
            minstack.push(value);
        }
        
    }
    
    public void pop() {
        if(stack.peek().equals(minstack.peek())){
            minstack.pop();
        }
        stack.pop();
        
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
        return minstack.peek();
        
    }
}

