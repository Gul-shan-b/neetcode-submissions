class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s:tokens){
            if(s.equals("+")){
                int top = st.pop();
                int top2= st.pop();
                int newt = top2+top;
                st.push(newt);
            }
            else if(s.equals("*")){
                int top = st.pop();
                int top2= st.pop();
                int newt = top2*top;
                st.push(newt);
            }
            else if(s.equals("-")){
                int top = st.pop();
                int top2 = st.pop();
                int newt = top2-top;
                st.push(newt);
            }
            else if(s.equals("/")){
                int top = st.pop();
                int top2 = st.pop();
                int newt =top2/top;
                st.push(newt);
            }
            else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.peek();
        
    }
}
