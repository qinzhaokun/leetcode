/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
*/

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int [] arr = new int [n];
        arr[0] = triangle.get(0).get(0);
        for(int i = 1;i < n;i++){
            arr[triangle.get(i).size()-1] = arr[triangle.get(i).size()-2] + (int)(triangle.get(i).get(triangle.get(i).size()-1));
            for(int j = triangle.get(i).size()-2;j > 0;j--){
                arr[j] = Math.min(arr[j],arr[j-1])+(int)triangle.get(i).get(j);
            }
            arr[0] += (int)(triangle.get(i).get(0));
        }
        
        int min = arr[0];
        for(int i = 1;i < n;i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
}
