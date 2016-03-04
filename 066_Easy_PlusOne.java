/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Subscribe to see which companies asked this question
*/

public class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length-1;
        for(;i >= 0;i--){
            if(digits[i] != 9){
                digits[i]++;
                break;
            }
            else{
                digits[i] = 0;
            }
        }
        if(i == -1){
            int [] newDigits = new int [digits.length+1];
            newDigits[0] = 1;
            return newDigits;
        }
        else{
            return digits;
        }
    }
}
