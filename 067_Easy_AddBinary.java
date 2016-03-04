/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/

public class Solution {
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0){
            return b;
        }
        if(b == null || b.length() == 0){
            return a;
        }
        if(a.length() < b.length()){
            String tmp = a;
            a = b;
            b = tmp;
        }
        int in = 0;
        int i = b.length()-1;
        int j = a.length()-1;
        char [] c = new char [a.length()];
        for(;i>=0;i--,j--){
            int num =(b.charAt(i)-'0')+(a.charAt(j)-'0')+in;
            in = num/2;
            c[j] = num%2==0 ? '0' : '1';
        }
        for(;j>=0;j--){
            int num =  (a.charAt(j)-'0')+in;
            in = num/2;
            c[j] = num%2==0 ? '0' : '1';
        }
        if(in == 1){
            return '1'+ new String(c);
        }
        else{
            return new String(c);
        }

    }
}
