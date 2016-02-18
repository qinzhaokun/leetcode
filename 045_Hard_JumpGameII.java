/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index
*/

//my sloution
public class Solution {
    public int jump(int[] nums) {
        //my soluton is complex.
        if(nums.length <=1){
            return 0;
        }
        int n = nums.length;
        int last = 0;//上一跳可达最远距离 
        int cur = 0;//当前一跳可达最远距
        int step = 0;//当前跳数
        for(int i = 0;i < n;i++){
            //无法向前继跳直接返回 
            if(i > cur){
                return -1;
            }
            //需要进行下次跳跃，则更新last和当执行的跳数step(上一条的最大位置已经不足以覆盖i，必须要加一条，last更新为当前搜索岛的最远位置cur. 
            if(i > last){
                last = cur;
                step++;
            }
            cur = Math.max(cur,i+nums[i]);
            if(cur >= n-1){
                return step+1;
            }
        }
        return step;
    }
}

//other solution
 int jump(int A[], int n) {
     if(n<2)return 0;
     int level=0,currentMax=0,i=0,nextMax=0;

     while(currentMax-i+1>0){       //nodes count of current level>0
         level++;
         for(;i<=currentMax;i++){   //traverse current level , and update the max reach of next level
            nextMax=max(nextMax,A[i]+i);
            if(nextMax>=n-1)return level;   // if last element is in level+1,  then the min jump=level 
         }
         currentMax=nextMax;
     }
     return 0;
 }
