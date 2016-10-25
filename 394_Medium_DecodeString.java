public class Solution {
    public String decodeString(String s) {
        Stack<Integer> sIn = new Stack();
        Stack<String> sSt = new Stack();
        String tmp = "";
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                int num = 0;
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    num = 10*num + (s.charAt(i)-'0');
                    i++;
                }
                i--;
                sIn.push(num);
            }
            else if(s.charAt(i) == '['){
                sSt.push(tmp);
                tmp = "";
            }
            else if(s.charAt(i) == ']'){
                StringBuilder sb = new StringBuilder(sSt.pop());
                int k = (int)sIn.pop();
                for(int q = 0;q < k;q++){
                    sb.append(tmp);
                }
                tmp = sb.toString();
            }
            else{
                tmp += s.charAt(i);
            }
        }
        return tmp;
    }
}
