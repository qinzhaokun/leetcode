/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
*/

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String [] arr = str.split(" ");
        if(arr.length != pattern.length()){
            return false;
        }
        Map<String,Character> map = new HashMap<>();
        Map<Character,String> map2 = new HashMap<>();
        for(int i = 0;i < arr.length;i++){
            if(map.containsKey(arr[i])){
                if((char)map.get(arr[i]) != pattern.charAt(i)){
                    return false;
                }
            }
            else if(map2.containsKey(pattern.charAt(i))){
                if(!map2.get(pattern.charAt(i)).equals(arr[i])){
                    return false;
                }
            }
            else{
                map.put(arr[i],pattern.charAt(i));
                map2.put(pattern.charAt(i),arr[i]);
            }
        }
        return true;
    }
}
