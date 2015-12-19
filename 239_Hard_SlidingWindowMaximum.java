/*
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?

Hint:

How about using a data structure such as deque (double-ended queue)?
The queue size need not be the same as the window’s size.
Remove redundant elements and the queue should store only elements that need to be considered.
*/

//My solution. beats 99.13% java coder without reason
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int [] re = new int [nums.length-k+1];
        int start = 0;
        for(int i = 1;i < k;i++){
            if(nums[i]  >= nums[start]){
                start = i;
            }
        }
        if(nums.length == 0){
            return new int [0];
        }
        re[0] = nums[start];
        for(int i = k;i < nums.length;i++){
            if(nums[i] >= nums[start]){
                start = i;
            }
            else if(i-k+1 > start){
                start = i-k+1;
                for(int j = i-k+2;j <=i;j++){
                    if(nums[j] >= nums[start]){
                        start = j;
                    }
                }
            }
            re[i-k+1] = nums[start];
        }
        return re;
    }
}

//Standard solution
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
        if(k==0) return new int[0];
        
        LinkedList<Integer> q = new LinkedList<Integer>();

        int[] res = new int[nums.length-k+1];
        
        for(int i=0; i<nums.length; i++) {
            while(!q.isEmpty() && nums[i]>=nums[q.getLast()]){
                q.removeLast();
            }
            q.addLast(i);
            
            if(i-q.getFirst()+1 > k) {
                q.removeFirst();
            }
            if(i+1>=k) res[i-k+1] = nums[q.getFirst()];
        }
        
        return res;
    }
}
