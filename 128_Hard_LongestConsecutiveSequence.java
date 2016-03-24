/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/

public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        if(nums.length < 1) return 0;
        int max = 1;
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(nums[i])) continue;
            else if(map.containsKey(nums[i]-1) && map.containsKey(nums[i]+1)){
                int left = map.get(nums[i]-1);
                int right = map.get(nums[i]+1);
                map.put(left,right);
                map.put(right,left);
                map.put(nums[i],0);
                if(right-left+1 > max) max = right-left+1;
                
            }
            else if(map.containsKey(nums[i]-1)){
                int left = map.get(nums[i]-1);
                map.put(left,nums[i]);
                map.put(nums[i],left);
                if(nums[i]-left+1 > max) {max = nums[i]-left+1;}
            }
            else if(map.containsKey(nums[i]+1)){
                int right = map.get(nums[i]+1);
                map.put(right,nums[i]);
                map.put(nums[i],right);
                if(right-nums[i]+1 > max) {max = right-nums[i]+1;}
            }
            else{
                map.put(nums[i],nums[i]);
            }
        }
        return max;
    }
}
