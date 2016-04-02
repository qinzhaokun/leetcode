/*
Given an array of integers, find out whether there are two distinct indices i and j in the array such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
*/


public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        HashMap<Long,Long> map = new HashMap<>();
        if(t < 0) return false;
        long bucket = (long)(t+1);
        for(int i = 0;i < nums.length;i++){
            long index = ((long)nums[i] - Integer.MIN_VALUE)/bucket;
            if(map.containsKey(index)) return true;
            if(map.containsKey(index-1)){
                long target = map.get(index-1);
                if(Math.abs(target-nums[i]) <= t) return true;
            } 
            if(map.containsKey(index+1)){
                long target = map.get(index+1);
                if(Math.abs(target-nums[i]) <= t) return true;
            }
            map.put(index,(long)nums[i]);
            if(i >= k) map.remove(((long)nums[i-k]-Integer.MIN_VALUE)/bucket);
        }
        return false;
    }
}
