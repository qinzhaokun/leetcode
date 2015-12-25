/*
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
*/

public class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        int min = nums[0];
        int max = nums[0];
        for(int i = 1;i < nums.length;i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        if(min == max){
            return 0;
        }
        //Then the maximum gap will be no smaller than ceiling[(max - min ) / (N - 1)]. think why?
        int gap = (int)Math.ceil((double)(max-min)/(nums.length-1));
        int num = nums.length;
        int [] Mins = new int [num];
        int [] Maxs = new int [num];
		    Arrays.fill(Mins, max);
		    Arrays.fill(Maxs, min);
		    for(int i:nums){
		        int index = (i-min)/gap;
		        Mins[index] = Math.min(Mins[index],i);
		        Maxs[index] = Math.max(Maxs[index],i);
		    }
		    int maxGap = 0;
		    if(!(Maxs[0] == min && Mins[0] == max)){
		      maxGap = Mins[0] - min;
		    }
		    int last = Maxs[0];
		    for(int i = 1;i < num;i++){
		      //empty bu
		    if(Maxs[i] == min && Mins[i] == max){
		        continue;
		    }
		    maxGap = Math.max(maxGap,Mins[i]-last);
		    last = Maxs[i];
		    
		    }
		return maxGap;
  }
}
