/*
Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.

Example1:

a = 2
b = [3]

Result: 8
Example2:

a = 2
b = [1,0]

Result: 1024
*/

public class Solution {
    public int superPow(int a, int[] b) {
        int n = b.length;
        int base = 0;
        int ret = 1;
        a %= 1337;
        if(a == 0) return a;
        for(int i = 0;i < n;i++){
            base = base*10+b[i];
            base %= 1140;
        }
        return cal(a,base);
    }
    
    int cal(int a, int b){
        if(b == 0) return 1;
        if(b == 1) return a;
        int tmp = cal(a,b/2);
        if((b&1)==1){
            return (tmp*tmp*a)%1337;
        }
        else return (tmp*tmp)%1337;
    }
} 
