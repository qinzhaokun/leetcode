public class Solution {

    int [] nums; 
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int n = nums.length;
        int [] ans = new int[n];
        Random r = new Random();
        for(int i = 0;i < n;i++){
            ans[i] = nums[i];
            int index = r.nextInt(i+1);
            
            int tmp = ans[index];
            ans[index] = ans[i];
            ans[i] = tmp;
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
