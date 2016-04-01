/*
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.
*/


public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while(m != n){
            m = m >> 1;
            n = n >> 1;
            count++;
        }
        return m << count;
    }
}

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int k = n-m;
        //int count = 0;
        int max = 2147483647;
        while(k != 0){
            max = (max << 1);
            k /= 2;
        }
        return (m & max & n);
    }
}
