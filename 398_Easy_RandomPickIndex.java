public class Solution {

   int [] nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        Random r = new Random();
        int ans = 0;
        int count = 1;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == target){
                if(r.nextInt(count++) == 0){
                    ans = i;
                }
            }
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
