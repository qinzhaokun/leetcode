/*
Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.

Subscribe to see which companies asked this question
*/

public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int base = 1;
        int tmp = x;
        tmp /= 10;
        while(tmp != 0){
            tmp /= 10;
            base *= 10;
        }
        while(x != 0){
            if(x / base != x % 10){
                return false;
            }
            x %= base;
            x/=10;
            base /= 100;
        }
        return true;
    }
}
