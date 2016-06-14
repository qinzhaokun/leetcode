/*
Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
*/

public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int sum = 0;
        if(n ==0) return 1;
        sum += 10;
        if(n == 1) return sum;
        for(int i = 1;i < n && i < 10;i++){
            int t = 9;
            for(int j = 0;j <= i-1;j++){
                t *= (9-j);
            }
            sum += t;
        }
        
        return sum;
    }
}
