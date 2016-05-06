/*
Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits. You should try to optimize your time and space complexity.

Example 1:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
return [9, 8, 6, 5, 3]

Example 2:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
return [6, 7, 6, 0, 4]

Example 3:
nums1 = [3, 9]
nums2 = [8, 9]
k = 3
return [9, 8, 9]
*/



public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k){
		int [] re = new int [k];
		int min = Math.min(nums1.length, k);
		for(int i = 0;i <= min;i++){
			if(k-i<=nums2.length) {
				int [] re1 = getKmax(nums1,i);
				int [] re2 = getKmax(nums2,k-i);
				int [] tmp = merge(re1,re2);
				if(greater(tmp,re)) re = tmp;
			}
			
		}
		return re;
	}
	
	public int [] getKmax(int nums[], int k){
		int [] re = new int [k];
		int n = nums.length;
		int j = 0;
		//using array to instead stack
		for(int i = 0;i < n;i++){
			while(j > 0 && re[j-1] < nums[i] && n-i > k-j) j--;
			if(j < k) re[j++] = nums[i];
		}
		return re;
	}
	
	public int [] merge(int [] nums1, int [] nums2){
		int k = nums1.length + nums2.length;
		int [] re = new int [k];
		int i = 0,j = 0,c = 0;
		while(i < nums1.length && j < nums2.length){
				int tmpI = i;
				int tmpJ = j;
				while(tmpI < nums1.length && tmpJ < nums2.length && nums1[tmpI] == nums2[tmpJ]) {tmpI++;tmpJ++;}
				
				if(tmpJ == nums2.length || (tmpI < nums1.length && nums1[tmpI] > nums2[tmpJ])) re[c++] = nums1[i++];
				else re[c++] = nums2[j++];
		}
		while(i < nums1.length) re[c++] = nums1[i++];
		while(j < nums2.length) re[c++] = nums2[j++];
		return re;
	}
	
	public boolean greater(int [] nums1, int [] nums2){
		for(int i = 0;i < nums1.length;i++){
			if(nums1[i] > nums2[i]) return true;
			else if(nums1[i] < nums2[i]) return false;
		}
		return true;
	}
}
