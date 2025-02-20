class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String token:tokens){
            if(isOperator(token)){
                int b=st.pop();
                int a=st.pop();
                st.push(applyOperator(a,b,token));
            }else{
            st.push(Integer.parseInt(token));
        }
     }
        return st.peek();
    }
    public boolean isOperator(String token){
        return token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/");
    }

    public int applyOperator(int a,int b,String token){
        if(token.equals("+")){
            return a+b;
        }else if(token.equals("-")){
            return a-b;
        }else if(token.equals("*")){
            return a*b;
        }else if( token.equals("/")){
            return a/b;
        }
        return 0;
    }
}