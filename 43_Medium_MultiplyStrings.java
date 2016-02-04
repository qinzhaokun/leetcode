/*
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.

Subscribe to see which companies asked this question
*/

public class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int tmp [] = new int [n1+n2];
        if(n1 == 0 || n2 == 0){
            return "";
        }
        for(int i = n1-1;i >= 0;i--){
            for(int j = n2-1;j >= 0;j--){
                tmp[n1+n2-i-j-2] += (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }
        int t = 0;
        for(int i = 0;i < n1+n2;i++){
            int k = t+tmp[i];
            tmp[i] = k%10;
            t = k/10;
        }
        boolean found = false;
        String re = "";
        for(int i = n1+n2-1;i >= 0;i--){
            if(found){
                re += tmp[i];
            }
            else{
                if(tmp[i] != 0){
                    re+= tmp[i];
                    found = true;
                }
            }
        }
        return re.length()==0?"0":re;
    }
}
