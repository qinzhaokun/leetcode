public class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        char [] a = s.toCharArray();
        return longest(a,0,n-1,k);
    }
    
    public int longest(char [] a, int i, int j, int k){
        if(j-i+1<k) return 0;
        int [] count = new int[26];
        int [] location = new int[26];
        for(int s = i;s <= j;s++){
            count[a[s]-'a']++;
            location[a[s]-'a'] = s;
        }
        
        for(int s = 0;s < 26;s++){
            if(count[s] > 0 && count[s] < k){
                int t = location[s];
                return Math.max(longest(a,i,t-1,k),longest(a,t+1,j,k));
            }
        }
        return j-i+1;
    }
}
