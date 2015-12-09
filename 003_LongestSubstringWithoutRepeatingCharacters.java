/*
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        //滑动窗口法
        boolean [] arrays = new boolean [256];
        int start = 0;
        int count = 0;
        int local_count = 0;
        for(int i = 0;i < s.length();i++){
            //the first ASCII character is ' ' 
            int num = s.charAt(i)-' ';
            if(!arrays[num]){
                local_count++;
                count = Math.max(count,local_count);
                arrays[num] = true;
            }
            else{
                while(start < i && arrays[num]){
                    arrays[s.charAt(start)-' '] = false;
                    local_count--;
                    start++;
                }
                arrays[num] = true;
                local_count++;
            }
        }
        return count;
    }
}
