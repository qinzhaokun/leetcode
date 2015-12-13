/*
Given an integer, write a function to determine if it is a power of two.
*/

public class Solution {
    public boolean isPowerOfTwo(int n) {
        int num = 1;
        for(int i = 0;i < 32;i++){
            if(n == num){
                return true;
            }
            else if(n < num){
                return false;
            }
            num = num << 1;
        }
        return false;
        
        //another solution
        //return n > 0 && ((n & (n - 1)) == 0 ); 
    }
}
