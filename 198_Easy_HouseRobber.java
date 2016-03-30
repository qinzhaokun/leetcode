/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/


public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        //a表示抢了第i个的最大收益
        int a = nums[0];
        //b表示不抢第i个的最大收益
        int b = 0;
        for(int i = 1;i < n;i++){
            //缓冲抢了i-1的房子的最大收益
            int tmp = a;
            //抢第i个房子，则不能抢i-1，所以是nums[i]+b
            a = nums[i] + b;
            //不抢第i个，则选取不抢第i-1个（b）和抢i-1个（tmp）的较大值。
            if(tmp > b) b = tmp;
        }
        return a > b ? a : b;
    }
}


public class Solution {
    //动态规划，设置maxV[i]表示到第i个房子位置，最大收益。

//递推关系为maxV[i] = max(maxV[i-2]+num[i], maxV[i-1])

//注：可能会对上述递推关系产生疑问，是否存在如下可能性，maxV[i-1]并不含num[i-1]？

//结论是，在这种情况下maxV[i-1]等同于maxV[i-2]，因此前者更大。
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int [] money = new int [nums.length];
        money[0] = nums[0];
        money[1] = Math.max(money[0],nums[1]);
        for(int i = 2;i < nums.length;i++){
                money[i] = Math.max(money[i-1],money[i-2]+nums[i]);
        }
        return money[nums.length-1];
    }
}
