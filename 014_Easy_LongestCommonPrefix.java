/*
Write a function to find the longest common prefix string amongst an array of strings.

Subscribe to see which companies asked this question
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null){
            return null;
        }
        if(strs.length == 0){
            return "";
        }
        String tar = strs[0];
        for(int i = 1;i < strs.length;i++){
            int j = 0;
            while(j < tar.length() && j < strs[i].length() && tar.charAt(j) == strs[i].charAt(j)){
                j++;
            }
            if(j == 0){
                return "";
            }
            tar = tar.substring(0,j);
        }
        return tar;
    }
    
}

public String longestCommonPrefix(String[] strs) {
    if(strs == null || strs.length == 0)    return "";
    String pre = strs[0];
    int i = 1;
    while(i < strs.length){
        while(strs[i].indexOf(pre) != 0)
            pre = pre.substring(0,pre.length()-1);
        i++;
    }
    return pre;
}
