/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.
Example:
Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:
The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
*/

public class NumArray {
    
    public class segmentTree {
        public int start;
        public int end;
        public segmentTree left;
        public segmentTree right;
        public int sum;
        
        public segmentTree(int start, int end){
            this.start = start;
            this.end = end;
            sum = 0;
            left = null;
            right = null;
        }
    }
    
    private segmentTree root;
    
    public NumArray(int[] nums) {
        if(nums.length != 0){
            root = build(0,nums.length-1,nums);
        }
    }
    
    segmentTree build(int start, int end, int [] nums){
        segmentTree node = new segmentTree(start,end);
        if(start == end){
            node.sum = nums[start];
        }
        else{
            int mid = start + (end-start)/2;
            node.left = build(start,mid,nums);
            node.right = build(mid+1,end,nums);
            node.sum = node.left.sum + node.right.sum;
        }
        return node;
    }

    void update(int i, int val) {
        update(root,i,val);
    }
    
    void update(segmentTree root, int i, int val){
        if(root.start == root.end){
            root.sum = val;
        }
        else{
            int mid = root.start + (root.end-root.start)/2;
            if(i <= mid){
                update(root.left,i,val);
            }
            else{
                update(root.right,i,val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(root,i,j);
    }
    
    int sumRange(segmentTree root, int i, int j){
        if(root.start == i && root.end == j){
            return root.sum;
        }
        else{
            int mid = root.start + (root.end-root.start)/2;
            if(j <= mid){
                return sumRange(root.left,i,j);
            }
            else if(i >= mid+1){
                return sumRange(root.right,i,j);
            }
            else{
                return sumRange(root.left,i,mid) + sumRange(root.right,mid+1,j);
            }
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
