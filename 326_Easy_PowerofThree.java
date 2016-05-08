/*
Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
*/

public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 1) return true;
        if(n % 3 != 0 || n == 0) return false;
        else return isPowerOfThree(n/3);
    }
}

public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0) return false;
        String tmp = Integer.toString(n,3);
        if(tmp.contains("2")) return false;
        int t = Integer.valueOf(tmp,2);
        return (t & t-1) == 0 ? true:false;
    }
}
