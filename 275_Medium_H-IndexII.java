/*
Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

Hint:

Expected runtime complexity is in O(log n) and the input is sorted.
*/

public class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 0){
            return 0;
        }
        int i = 0;
        int j = citations.length-1;
        while(j-i>1){
            int mid = (i+j)/2;
            if(citations[mid] >= citations.length-mid){
                j = mid;
            }
            else{
                i = mid;
            }
        }
        if(citations[i] >= citations.length-i){
            return citations.length-i;
        }
        else if(citations[j] >= citations.length-j){
            return citations.length-j;
        }
        else{
            return 0;
        }
    }
}
