/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
*/

public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int [] candy = new int [n];
        candy[0] = 1;
        for(int i = 1; i < n;i++){
            if(ratings[i] > ratings[i-1]) candy[i] = candy[i-1]+1;
            else{
                candy[i] = 1;
                if(ratings[i] < ratings[i-1] && candy[i-1] == 1) candy[i-1]++;
            }
        }
        int sum = candy[n-1];
        for(int i = n-2;i >= 0;i--){
            if(ratings[i] > ratings[i+1] && candy[i] <= candy[i+1]) candy[i] = candy[i+1]+1;
            sum += candy[i];
        }
        return sum;
    }
}
