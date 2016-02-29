/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.
*/

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Arrays.sort(strs);
        Map<String,ArrayList<String>> map = new HashMap<>();
        for(String str:strs){
            char [] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String newStr = String.valueOf(tmp);
            if(!map.containsKey(newStr)){
               map.put(newStr,new ArrayList<String>()); 
            }
            map.get(newStr).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
