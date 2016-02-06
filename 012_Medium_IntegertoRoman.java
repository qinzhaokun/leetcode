/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

Subscribe to see which companies asked this question
*/

public class Solution {
    public String intToRoman(int num) {
        String [] a = {"I","V","X","L","C","D","M"};
        int i = 0;
        String re = "";
        while(num != 0){
            int tmp = num%10;
            switch(tmp){
                case 0:
                    break;
                case 1:
                    re  = a[i] + re ;
                    break;
                case 2:
                    re = a[i]+a[i] + re;
                    break;
                case 3:
                    re = a[i] + a[i] +a[i] + re;
                    break;
                case 4:
                    re = a[i] + a[i+1] + re;
                    break;
                case 5:
                    re = a[i+1] + re;
                    break;
                case 6:
                    re = a[i+1] + a[i] + re;
                    break;
                case 7:
                    re = a[i+1] + a[i] + a[i] + re;
                    break;
                case 8:
                    re = a[i+1] + a[i] + a[i] + a[i] + re;
                    break;
                case 9:
                    re = a[i] + a[i+2] + re;
            }
            i+=2;
            num /= 10;
        }
        return re;
    }
}
