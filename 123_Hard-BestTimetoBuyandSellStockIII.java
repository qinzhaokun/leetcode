/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.
*/

public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n < 2) {return 0;}
        int [] left = new int [n];
        int [] right = new int [n];
        int min = prices[0];
        for(int i = 1;i < n;i++){
            left[i] = left[i-1];
            if(min > prices[i]) {min = prices[i];}
            if(left[i] < prices[i]-min) {left[i] = prices[i]-min;}
        }
        
        int max = prices[n-1];
        for(int j = n-2;j >= 0;j--){
            right[j] = right[j+1];
            if(prices[j] > max) {max = prices[j];}
            if(right[j] < max-prices[j]) {right[j] = max-prices[j];}
        }
        int sum = 0;
        for(int k = 0;k < n;k++){
            if(sum < left[k]+right[k]) {sum = left[k]+right[k];}
        }
        return sum;
    }
}
