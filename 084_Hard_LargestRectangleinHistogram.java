/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.

Subscribe to see which companies asked this question
*/

//using Stack
public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for(int i = 0;i < heights.length;i++){
            if(stack.isEmpty() || heights[(int)stack.peek()] < heights[i]){
                stack.push(i);
            }
            else{
                int height = heights[(int)stack.pop()];
                int left = stack.isEmpty() ? -1 : (int)stack.peek();
                area = Math.max(area,height*(i-left-1));
                i--;
            }
        }
        while(!stack.isEmpty()){
            int i = (int)stack.pop();
            int left = stack.isEmpty() ? -1 : (int)stack.peek();
            area = Math.max(area,heights[i]*(heights.length-1-left));
        }
        return area;
    }
}

//using Dynamic Programming
public static int getMaxRectangle (int heights[]){
        int ans = 0;
        int n = heights.length;
        int left[] = new int[n+1];
        int right[] = new int[n+1];
        processLR(heights, left, right);
        for(int i=1; i<=n; i++){
            int tmp = (right[i]-left[i]+1) * heights[i-1];
            if( ans < tmp)
                ans = tmp;
        }
        return ans;
    }
    public static void processLR(int heights[], int left[], int right[]){
        int n = heights.length;
        //用临时数组，设置两个哨兵
        int tempArr[] = new int[n+2];
        tempArr[0] = -1;
        for(int i=1; i<=n; i++) tempArr[i] = heights[i-1];
        tempArr[tempArr.length-1] = -1;
        for(int i=1; i<=n; i++){
            int k = i;
            while( tempArr[i] <= tempArr[k-1])
                k = left[k-1];
            left[i] = k;
        }
        for(int i=n; i>0; i--){
            int k = i;
            while(  tempArr[i] <= tempArr[k+1])
                 k = right[k+1];
            right[i] = k;
        }
    }
