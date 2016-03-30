/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
*/


public class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String [] s = new String [n];
        for(int i = 0;i < n;i++) s[i] = String.valueOf(nums[i]);
        mergesort(s,0,n-1);
        StringBuilder sb = new StringBuilder();
        for(String s1:s) sb.append(s1);
        String re = sb.toString();
        int i = 0;
        while(i < re.length() && re.charAt(i) == '0') i++;
        return i == re.length() ? "0":re.substring(i,re.length());
    }
    
    void mergesort(String [] s, int i, int j){
        if(i < j){
            int mid = i + (j-i)/2;
            mergesort(s,i,mid);
            mergesort(s,mid+1,j); 
            int len = j-i+1;
            String [] tmp = new String [len];
            int i1 = i;
            int j1 = mid+1;
            int index = 0;
            while(i1 <= mid && j1 <= j){
                if(compare(s[i1],s[j1])) {tmp[index++] = s[i1];i1++;}
                else {tmp[index++] = s[j1];j1++;}
            }
            while(i1 <= mid){tmp[index++] = s[i1];i1++;}
            while(j1 <= j) {tmp[index++] = s[j1];j1++;}
            for(i1 = i;i1 <= j;i1++) s[i1] = tmp[i1-i];
        }
        
    }
    
    boolean compare(String s, String t){
        long k1 = Long.parseLong(s+t);
        long k2 = Long.parseLong(t+s);
        if(k1 >= k2) return true;
        else return false;
    }
}
