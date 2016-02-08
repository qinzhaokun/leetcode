/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/

public class Solution {
    public List<String> letterCombinations(String digits) {
        String [] map = {"_","o","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> re = new ArrayList<>();
        dfs(digits,re,"",map);
        return re;
    }
    
    void dfs(String digits, List re, String tmp, String [] map){
        if(digits == null || digits.length() == 0){
            if(tmp.length() != 0){
               re.add(tmp); 
            }
        }
        else{
            int a = digits.charAt(0)-'0';
            for(int i = 0;i < map[a].length();i++){
                dfs(digits.substring(1),re,tmp+map[a].charAt(i),map);
            }
        }
    }
}
