/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
Hint:

No scary math, just apply elementary math knowledge. Still remember how to perform a long division?
Try a long division on 4/9, the repeating part is obvious. Now try 4/333. Do you see a pattern?
Be wary of edge cases! List out as many test cases as you can think of and test your code thoroughly.
*/


public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean isNe = false;
        long n = numerator;
        long d = denominator;
        if((n < 0 && d > 0) || (n > 0 && d < 0)) isNe = true;
        if(n < 0) n = -n;
        if(d < 0) d = -d;
        StringBuilder sb = new StringBuilder();
        sb.append(""+n/d);
        long k = n%d;
        if(k != 0) sb.append(".");
        HashMap<Long,Integer> map = new HashMap();
        map.put(k,sb.length());
        while(k != 0){
            k *= 10;
            if(k < d){
                sb.append("0");
                map.put(k,sb.length());
            }
            else{
                sb.append("" + k/d); 
                k = k % d;
                if(map.containsKey(k)){
                    int pos = map.get(k);
                    sb.insert(pos,"(");
                    sb.append(")");
                    break;
                }
                else{
                    map.put(k,sb.length());
                }
            }
        }
        return !isNe ? sb.toString(): "-"+sb.toString();
    }
}
