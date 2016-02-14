/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Subscribe to see which companies asked this question
*/

//baoli
public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null){
            return -1;
        }
        int n = haystack.length();
        int m = needle.length();
        int del = n-m;
        if(del < 0){
            return -1;
        }
        for(int i = 0;i <= del;i++){
            if(haystack.substring(i,i+m).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}


//KMP
public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        if(needle.length()>haystack.length()||haystack.length()==0){
            return -1;
        }
        int []next = makeNext(needle);
        int j = 0;
        for(int i = 0;i<haystack.length();i++){
            if(needle.charAt(j)==haystack.charAt(i)) {
                j++;
            }
            else{
            	if(j>0) {
            		j = next[j-1];
            		i--;
            	}
            }
            if(j==needle.length()){
            	return i-needle.length()+1;
            }
            if(j==0&&haystack.length()-i<needle.length()){
                return -1;
            }
        }
        return -1;
    }
    
    public int [] makeNext(String needle) {
        int []next = new int[needle.length()];
        next[0] = 0;
        for (int i =1;i<needle.length();i++){
        	int k = next[i-1];
            while(k>0&&needle.charAt(i)!=needle.charAt(k)) {
                k = next[k-1];
            }
            if(needle.charAt(i)==needle.charAt(k)){
            	next[i] = k+1;
            }
            else{
            	next[i] = 0;
            }
        }
        return next;
    }
}
