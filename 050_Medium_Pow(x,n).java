/*
Implement pow(x, n).
*/

public class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        else{
            if(n < 0){
                n = -n;
                x = 1/x;
            }
            double val = myPow(x,n/2);
            val *= val;
            return (n %2 == 1) ? val*x:val;
        }
    }
}
