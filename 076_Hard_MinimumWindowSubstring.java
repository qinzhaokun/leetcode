/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/

public class Solution {
    public String minWindow(String s, String t) {
        int [] d = new int [300];
        boolean [] g = new boolean[300];
        for(int i = 0;i < t.length();i++){
            d[t.charAt(i) - ' ']++;
            g[t.charAt(i) - ' '] = true;
        }
        int n = t.length();
        int point1 = 0;
        int re = s.length()+1;
        int count = 0;
        String re1 = "";
        for(int j = 0;j < s.length();j++){
            int lo = s.charAt(j) - ' ';
            if(g[lo]){
                    d[lo]--;
                    if(d[lo] >= 0){
                      count++;  
                    }
                    
                    if(count == n){
                        while(true){
                            int k = s.charAt(point1)-' ';
                            if(!g[k]){
                                point1++;
                                continue;
                            }
                            else{
                                if(d[k]<0){
                                    d[k]++;
                                    point1++;
                                    continue;
                                }
                                else{
                                   if(re > j-point1+1){
                                      re = j-point1+1;
                                      re1 = s.substring(point1,j+1);
                                   }
                                   d[k]++;
                                   count--;
                                   point1++;
                                   break;
                                }
                            }
                        }
                    }
            }
        }
        
        return re1;
    }
}
