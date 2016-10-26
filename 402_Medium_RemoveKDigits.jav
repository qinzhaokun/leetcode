public class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> s = new Stack();
        for(int i = 0;i < num.length();i++){
            int t = num.charAt(i)-'0';
            if(k == 0 || s.isEmpty() || (int)s.peek() <= t){
                s.push(t);
            }
            else{
                while(k > 0 && !s.isEmpty() && (int)s.peek() > t){
                    s.pop();
                    k--;
                }
                s.push(t);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            String tmp = ""+ (int)s.pop();
            sb.append(tmp);
        }
        String ans = sb.reverse().toString();
        ans = ans.substring(0,ans.length()-k);
        int i = 0;
        while(i < ans.length() && ans.charAt(i) == '0') i++;
        
        if(i == ans.length()) return "0";
        else return ans.substring(i);
    }
}
