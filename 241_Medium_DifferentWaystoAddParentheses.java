/*
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
*/

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> re = new ArrayList<>();
        for(int i = 0;i < input.length();i++){
            if(input.charAt(i) - '0' >= 0 && input.charAt(i) - '0' <= 9){
                continue;
            }
            else{
                List left = diffWaysToCompute(input.substring(0,i));
                List right = diffWaysToCompute(input.substring(i+1,input.length()));
                for(int j = 0;j < left.size();j++){
                    for(int k = 0;k < right.size();k++){
                        re.add(comput((int)left.get(j),(int)right.get(k),input.charAt(i)));
                    }
                }
            }
        }
        if(re.isEmpty()){
            re.add(Integer.parseInt(input));
        }
        return re;
    }
    
    int comput(int a,int b,char op){
        switch(op){
            case '+':return a+b;
            case '-':return a-b;
            case '*':return a*b;
        }
        return 0;
    }
}
