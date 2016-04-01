/*
Description:

Count the number of prime numbers less than a non-negative number, n.
*/


public class Solution {
    public int countPrimes(int n) {
        boolean [] arr = new boolean [n+1];
        int i = 2;
        //n = 10
        while(i*i <= n){
            if(!arr[i]){
                for(int j = i*i;j < n;j += i){
                    arr[j] = true;
                }
            }
            i++;
        }
        int count = 0;
        for(i = 2;i < n;i++)
            if(!arr[i]) count++;
        return count;
    }
}
