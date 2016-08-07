/*
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.
*/

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int []> queue = new PriorityQueue<int []>(
                (o1,o2) -> o1[0]-o2[0]);

        int n = matrix.length;
        for(int i = 0;i < n;i++){
            queue.add(new int[] {matrix[i][0],i,0});
        }
        
        int index = 0;
        while(true){
            int [] a = queue.poll();
            if(index+1 == k) return a[0];
            if(a[2]+1 < n){
                queue.add(new int[] {matrix[a[1]][a[2]+1],a[1],a[2]+1});
            }
            index++;
        }
    }
}
