/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/

public class Solution {
    public String countAndSay(int n) {
        String a = "1";
        for(int i = 1;i < n;i++){
            StringBuilder tmp = new StringBuilder();
            int count = 1;
            char t = a.charAt(0);
            for(int j = 1;j < a.length();j++){
                if(a.charAt(j) == t){
                    count++;
                }
                else{
                    tmp.append(String.valueOf(count));
                    tmp.append(String.valueOf(t));
                    count = 1;
                    t = a.charAt(j);
                }
            }
            tmp.append(String.valueOf(count));
            tmp.append(String.valueOf(t));
            a = tmp.toString();
        }
        return a;
    }
}
