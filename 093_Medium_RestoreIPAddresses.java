/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> re = new ArrayList<>();
        dfs(0,"",s,re);
        return re;
    }
    
    void dfs(int index, String now, String s, List re){
        if(index == 4){
            if(s.length() > 0){
                return;
            }
            re.add(now.substring(0,now.length()-1));
        }
        else{
            if(3*(4-index) < s.length() || 4-index > s.length()){
                return;
            }
            if(s.length() > 0 && s.charAt(0) == '0'){
                dfs(index+1,now+"0.",s.substring(1),re);
            }
            else{
               for(int i = 1;i < 4 && i <= s.length();i++){
                int tmp = Integer.parseInt(s.substring(0,i));
                if(tmp <= 255){
                    dfs(index+1,now+String.valueOf(tmp)+".",s.substring(i),re);
                }
               } 
            }
            
        }
    }
}
