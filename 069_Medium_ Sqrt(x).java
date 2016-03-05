/*
Implement int sqrt(int x).

Compute and return the square root of x.
*/

public class Solution {
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        int i = 1;
        int j = x-1;
        while(i < j){
            int mid = i + (j-i)/2 +1;
            double tmp = (double)(mid)*(double)(mid);
            if(tmp <= (double)x){
                i = mid;
            }
            else{
                j = mid-1;
            }
        }
        return i;
    }
}
