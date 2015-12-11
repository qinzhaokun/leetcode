/*
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
Note: Do not use the eval built-in library function.
*/

public class Solution {
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if( c == ' '){
                continue;
            }
            //when occur + - ( ,push into stack
            if( c == '+' ||c == '-' || c == '('){
                stack.push(String.valueOf(c));
            }
            else if(c == ')'){
                String number = stack.pop();
                String symbol = stack.pop();
                while(!symbol.equals("(")){
                    String number1 = stack.pop();
                    int c1 = Integer.parseInt(number1);
                    int c2 = Integer.parseInt(number);
                    if(symbol.equals("+")){
                        
                        number =  String.valueOf(c1+c2);
                    }
                    else{
                        number = String.valueOf(c1-c2);
                    }
                    symbol = stack.pop();
                }
                if(stack.isEmpty()){
                    stack.push(number);
                }
                else{
                    symbol = stack.pop();
                    String number1 = stack.pop();
                    if(symbol.equals("+")){
                        stack.push(String.valueOf(Integer.parseInt(number1)+Integer.parseInt(number)));
                    }
                    else{
                        stack.push(String.valueOf(Integer.parseInt(number1)-Integer.parseInt(number)));
                    }
                }
            }
            else{
                String num = c + "";
                i++;
                while(i < s.length() && s.charAt(i) - '0' >= 0 && '9'-s.charAt(i) >= 0){
                    num += s.charAt(i);
                    i++;
                }
                i--;
                if(stack.isEmpty() || stack.peek().equals("(")){
                    stack.push(num);
                    continue;
                }
                String symbol = stack.pop();
                String number = stack.pop();
                if(symbol.equals("+")){
                    stack.push(String.valueOf(Integer.parseInt(number)+Integer.parseInt(num)));
                }
                else{
                    stack.push(String.valueOf(Integer.parseInt(number)-Integer.parseInt(num)));
                }
            }
        }
        
        String number = stack.pop();
        
        return Integer.parseInt(number);
    }
}
