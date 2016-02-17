/*
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
*/

public class Solution {
    int total;
    int len;
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String,Integer> map = new HashMap<>();
        total = words.length;
        List<Integer> re = new ArrayList<>();
        if(total == 0){
            return re;
        }
        len = words[0].length();
        for(String word:words){
            if(map.containsKey(word)){
                int num = (int)map.get(word);
                map.put(word,num+1);
            }
            else{
                map.put(word,1);
            }
        }
        for(int i = 0;i < len;i++){
            int left = i;
            int count = 0;
            Map<String,Integer> curMap = new HashMap<>();
            for(int j = i;j <= s.length()-len;j+=len){
                String tmp = s.substring(j,j+len);
                if(map.containsKey(tmp)){
                    if(curMap.containsKey(tmp)){
                        int num = curMap.get(tmp);
                        if(num == (int)map.get(tmp)){
                            String tmp1 = s.substring(left,left+len);
                            while(!tmp.equals(tmp1)){
                              curMap.put(tmp1,(int)curMap.get(tmp1)-1);
                              left += len;
                              count--;
                              tmp1 = s.substring(left,left+len);
                            }
                            if(left != j){
                                left += len; 
                            }
                        }
                        else{
                            curMap.put(tmp,num+1);
                            count++;
                        }
                    }
                    else{
                        curMap.put(tmp,1);
                        count++;
                    }
                    if(count == total){
                        re.add(left);
                        String tmp1 = s.substring(left,left+len);
                        curMap.put(tmp1,(int)curMap.get(tmp1)-1);
                        left +=len;
                        count--;
                        
                    }
                }
                else{
                    left = j+len;
                    count = 0;
                    curMap.clear();
                }
            }
        }
        return re;
    }
    
}
