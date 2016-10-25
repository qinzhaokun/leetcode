public class Solution {
    public int integerReplacement(int n) {
        if(n == Integer.MAX_VALUE) return 32;
        if(n <= 3) return n-1;
        if((n&1) == 0) return 1+integerReplacement(n/2);
        else{
            if(((n >> 1)&1) == 1) return 1+integerReplacement(n+1);
            else return 1+integerReplacement(n-1);
        }
    }
    
}
