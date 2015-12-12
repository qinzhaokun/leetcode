/*
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
Note: Do not use the eval built-in library function.
*/

public class Solution {
    public int calculate(String s) {
        Stack<String> stack = new Stack<> ();
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(c == ' '){
                continue;
            }
            else if(c == '*' || c == '/' || c == '+' || c == '-'){
                stack.push(c+"");
            }
            else{
                String tmp = c+"";
                int j = i+1;
                for(;j < s.length();j++){
                    if(s.charAt(j)-'0'>=0 && s.charAt(j) - '0'<=9){
                        tmp += s.charAt(j);
                    }
                    else{
                        break;
                    }
                }
                i = j-1;
                if(!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/"))){
                    String symbol = stack.pop();
                    int num = Integer.valueOf(tmp);
                    int number = Integer.valueOf(stack.pop()+"");
                    if(symbol.equals("*")){
                        stack.push((num*number)+"");
                    }
                    else{
                        stack.push((number/num)+"");
                    }
                }
                else{
                    stack.push(tmp);
                }
            }
        }
        
        Stack<String> stack1 = new Stack<> ();
        while(!stack.isEmpty()){
            stack1.push(stack.pop());
        }
        while(stack1.size() > 1){
            int num1 = Integer.valueOf(stack1.pop());
            String symbol = stack1.pop();
            int num2 = Integer.valueOf(stack1.pop());
            if(symbol.equals("+")){
                stack1.push((num1+num2)+"");
            }
            else{
                stack1.push((num1-num2)+"");
            }
        }
        
        return Integer.valueOf(stack1.pop());
    }
}
