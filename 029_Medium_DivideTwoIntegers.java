/*
Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
*/

public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0){
            return Integer.MAX_VALUE;
        }
        boolean isNegative1 = false;
        boolean isNegative2 = false;
        long a1 = dividend;
        long a2 = divisor;
        if(dividend < 0){
            isNegative1 = true;
            a1 = 0-a1;
        }
        if(divisor < 0){
            isNegative2 = true;
            a2 = 0-a2;
        }
        long re = 0;
        while(a1 >= a2){
            long base = a2;
            int k = 1;
            while(a1 >= base){
                a1 -= base;
                re += k;
                k <<= 1;
                base <<= 1;
            }
        }
        if((isNegative1 && !isNegative2) || (!isNegative1 && isNegative2)){
            
            return 0-re <= Integer.MIN_VALUE ? Integer.MIN_VALUE:(int)(0-re);
        }
        else{
            return re >= Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)re;
        }
    }
}
