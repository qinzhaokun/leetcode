/*
Given an array of integers, every element appears three times except for one. Find that single one.
*/

public class Solution {
    //这个题有类似于single number的解法，即通过位运算，一遍扫描得到结果。还是读书的时候见过，大概是两个变量，相互做异或、补之类的运算，早不记得详情了。

//现在的解法是比较普通的。因为题目已经说了，除了一个数字以外，其他的都出现了3次，如果我们把那个特殊的数剔除，并把剩下的数于每一位来加和的话，每一位上1出现的次数必然都是3的倍数。所以，解法就在这里，将每一位数字分解到32个bit上，统计每一个bit上1出现的次数。最后对于每一个bit上1出现的个数对3取模，剩下的就是结果。
    public int singleNumber(int[] nums) {
        int [] a = new int [32];
        for(int i = 0;i < nums.length;i++){
            for(int j = 0;j < 32;j++){
                a[j] += ((nums[i] >> j) & 1); 
            }
        }
        int re = 0;
        for(int j = 0;j < 32;j++){
            re += ((a[j] % 3) << j);
        }
        return re;
    }
}
