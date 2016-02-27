/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/

//my solution O(2n) and O(2n)
public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n < 3){
            return 0;
        }
        int [] left = new int [n];
        left[0] = height[0];
        for(int i = 1;i < n-1;i++){
            left[i] = Math.max(height[i],left[i-1]);
        }
        int [] right = new int [n];
        right[n-1] = height[n-1];
        int sum = 0;
        for(int i = n-2;i > 0;i--){
            right[i] = Math.max(right[i+1],height[i]);
            sum += (Math.min(right[i],left[i]) - height[i]);
        }
        return sum;
    }
}

//standard solution O(n) and O(1)
public class Solution {
    public int trap(int[] heights) {

        if ( heights.length <= 2 ) { return 0; }

        int left = 0, right = heights.length-1, totalArea = 0;
        int leftMaxHeight = heights[left], rightMaxHeight = heights[right];

        while ( left < right ) {
            if ( heights[left] < heights[right] ) {
                leftMaxHeight = Math.max(leftMaxHeight, heights[++left]);
                totalArea += leftMaxHeight-heights[left];
            } else {
                rightMaxHeight = Math.max(rightMaxHeight, heights[--right]);
                totalArea += rightMaxHeight-heights[right];
            } 
        }
        return totalArea;
    }
}
