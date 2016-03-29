/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Note:
Your solution should be in logarithmic complexity.
*/

public class Solution {
    
    //1. 这里之所以选择只进行中间元素mid跟其相邻后续元素mid+1的大小讨论，而不涉及前一个元素mid-1，主要是方便。mid=(left+right)/2, 这个除法有一个floor效果在里面，即?(left+right)/2?。这样导致left和right不等时，index为mid和mid+1都存在，但是mid-1有可能小于0。这样每次当mid==0时，mid-1的元素都得特别讨论，麻烦。举个例子，比如left==0, right==1, mid==0, mid-1==-1, mid+1==1，不想讨论mid-1这种情况
//2. 如果中间元素大于其相邻后续元素，说明中间元素左侧(包含该中间元素）必包含一个局部最大值，这时候中间元素是可能是局部最大点的，所以移动r = mid而不是r = mid-1; 而如果中间元素小于其相邻后续元素，则中间元素右侧必包含一个局部最大值。这时中间元素肯定不会是局部最大点，所以移动l = mid + 1
//3. 之所以要用左右边沿相遇作为找到条件，主要也是不想涉及到mid-1的问题。否则条件是num[mid]>num[mid+1] && num[mid]>num[mid-1]又要分情况mid==0了
//4. 如果mid是一个valley, 比如[1, 2, 1, 6, 7], 这时候不知道该往哪边跳？这时候其实往左往右跳都可以。随便指定一个方向都可以，要么往左找到2，要么往右找到7（根据定义它也是peak value）。 因为只用找出一个，所以还是O(logN)

    public int findPeakElement(int[] nums) {
        int l = nums.length - 1;
        int i = 0;
        while(i < l){
            int mid = (i+l)/2;
            if(nums[mid] > nums[mid+1]){
                l = mid;
            }
            else{
                i = mid+1;
            }
        }
        return i;
    }
}

public class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length-1;
        if(n == 0) return 0;
        return find(nums,0,n);
    }
    
    int find(int [] nums, int i , int j){
        if(i <= j){
            int mid = i + (j-i)/2;
            if(mid == 0 && nums[0] > nums[1]) return 0;
            if(mid == nums.length-1 && nums[mid] > nums[mid-1]) return mid;
            if(mid > 0 && mid < nums.length-1 && nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
            int tmp = find(nums,i,mid-1);
            if(tmp != -1) return tmp;
            else return find(nums,mid+1,j);
        }
        else {
            return -1;
        }
        
    }
}
