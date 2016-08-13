/*
Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
Subscribe to see which companies asked this question
*/


class Solution {
    
    private: vector<int> nums;
    vector<int> re;
public:
    void next_premutation(){
        int n = re.size();
        int j = n-2;
        while(j >= 0 && re[j]>re[j+1])j--;
        if(j >= 0){
            int i = n-1;
            while(re[i]< re[j])i--;
            swap(re[i],re[j]);
            j++;
        }
        else{
            j = 0;
        }
        int i = n-1;
        while(j < i){
            swap(re[j],re[i]);
            j++;
            i--;
        }
    }
    
    Solution(vector<int> nums) {
        this->nums = nums;
        this->re = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    vector<int> reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    vector<int> shuffle() {
        next_premutation();
        
        return re;
    }
    

};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * vector<int> param_1 = obj.reset();
 * vector<int> param_2 = obj.shuffle();
 */
