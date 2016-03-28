/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0;i < tokens.length;i++){
            if(tokens[i].equals("+")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2+num1);
            }
            else if(tokens[i].equals("-")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2-num1);
            }
            else if(tokens[i].equals("*")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2*num1);
            }
            else if(tokens[i].equals("/")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2/num1);
            }
            else{
                stack.push(Integer.parseInt(tokens[i]));
            }
            
        }
        return stack.pop();
    }
}
