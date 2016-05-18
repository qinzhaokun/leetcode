/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
*/

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0;i < nums1.length;i++){
            if(!set.contains(nums1[i])) set.add(nums1[i]); 
        }
        
        List tmp = new ArrayList();
        for(int i = 0;i < nums2.length;i++){
            if(set.contains(nums2[i])) {tmp.add(nums2[i]);set.remove(nums2[i]);}
        }
        
        int [] ret = new int [tmp.size()];
        for(int i = 0;i < tmp.size();i++) ret[i] = (int)tmp.get(i);
        
        return ret;
    }
}
