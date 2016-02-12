/*
Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

For example:
"112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
"199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
1 + 99 = 100, 99 + 100 = 199
Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Follow up:
How would you handle overflow for very large input integers?
*/

public class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for(int i = 1;i <= n/2;i++){
            for(int j = i+1;j <= n-i;j++){
                if(dfs(num.substring(0,i),num.substring(i,j),num.substring(j))){
                    return true;
                }
            }
        }
        return false;
    }
    
    boolean dfs(String num1,String num2,String nums){
        if((num1.length()>1 && num1.charAt(0) == '0') || (num2.length() > 1 && num2.charAt(0) == '0')){
            return false;
        }
        long n1 = Long.valueOf(num1);
        long n2 = Long.valueOf(num2);
        String sum = String.valueOf(n1+n2);
        if(nums.equals(sum)){
          return true;  
        }
        else{
            if(sum.length()<nums.length() && nums.substring(0,sum.length()).equals(sum)){
                return dfs(num2,sum,nums.substring(sum.length()));
            }
            else{
                return false;
            }
        }
    }
}
