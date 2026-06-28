class MyStack {
    private Deque<Integer> prim = new ArrayDeque<>();
    private Deque<Integer> auxil = new ArrayDeque<>();


    public MyStack() {
        
    }
    
    public void push(int x) {
        auxil.offer(x);
        while(!prim.isEmpty()){
            auxil.offer(prim.poll());
        }
        Deque<Integer> temp = prim;
        prim = auxil;
        auxil = temp;
        
    }
    
    public int pop() {
        return prim.poll();
        
    }
    
    public int top() {
        return prim.peek();
        
    }
    
    public boolean empty() {
        return prim.isEmpty();
        
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */