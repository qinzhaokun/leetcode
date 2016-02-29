/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

//dp
public class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int max = nums[0];
        for(int i = 1;i < nums.length;i++){
            if(maxSum < 0){
                maxSum = 0;
            }
            maxSum += nums[i];
            max = Math.max(max,maxSum);
        }
        return max;
    }
}


//divide and conquer
public class Solution {
    public int maxSubArray(int[] nums) {
        return maxmy(nums,0,nums.length-1);
    }
    
    public int maxmy(int [] nums, int left,int right){
        if(left==right){
            return nums[left];
        }
        else if(left<right){
            int mid = (left+right)/2;
            int max1 = maxmy(nums,left,mid-1);
            int max2 = maxmy(nums,mid+1,right);
            int sum = nums[mid];
            int leftmax = sum;
            for(int i=mid-1;i>=left;i--){
                sum+=nums[i];
                if(sum>leftmax){
                    leftmax = sum;
                }
            }
            sum = nums[mid];
            int rightmax = sum;
            for(int i=mid+1;i<=right;i++){
                sum+=nums[i];
                if(sum>rightmax){
                    rightmax = sum;
                }
            }
            int max3 = leftmax+rightmax-nums[mid];
            int re = max1;
            if(max2>re){
                re = max2;
            }
            if(max3>re){
                re = max3;
            }
            return re;
        }
        else{
            return Integer.MIN_VALUE;
        }
    }
    
}
