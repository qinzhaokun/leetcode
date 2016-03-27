/*
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/

public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        int n  = s.length();
        
        
        List re = new ArrayList();
        boolean [] me = new boolean [n];
        dfs(n,0,"",re,s,wordDict,me);
        return re;
        
        
    }
    
    void dfs(int n,int i, String tmp, List re,String s, Set<String> wordDict, boolean [] me){
        if(i == n){
            re.add(tmp.substring(0,tmp.length()-1));
        }
        else{
            for(int j = i;j < n;j++){
                if(wordDict.contains(s.substring(i,j+1)) && !me[j]) {
                    int before = re.size();
                    dfs(n,j+1,tmp + s.substring(i,j+1)+" ",re,s,wordDict,me);
                    int after = re.size();
                    if(after == before) me[j] = true;
                }
            }
        }
    }
}
