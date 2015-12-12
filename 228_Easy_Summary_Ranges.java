/*
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> re = new ArrayList<>();
        if(nums.length == 0){
            return re;
        }
        int start = nums[0];
        int end = nums[0];
        for(int i = 1;i < nums.length;i++){
            if(nums[i] == nums[i-1]+1){
                end++;
            }
            else{
                if(start == end){
                   re.add(start+""); 
                }
                else{
                    re.add(start + "->" + end);
                }
                start = nums[i];
                end = nums[i];
            }
        }
        if(start == end){re.add(start+"");}
        else{re.add(start + "->" + end);}
        return re;
    }
}
