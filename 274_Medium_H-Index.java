/*
Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.

Hint:

An easy approach is to sort the array first.
What are the possible values of h-index?
A faster approach is to use extra space.
*/

//easy solution O(n*lgn)
public class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 0){
            return 0;
        }
        Arrays.sort(citations);
        for(int i = 0;i < citations.length;i++){
            if(citations[i] >= citations.length-i && (i == 0 || citations[i-1] <= citations.length-i)){
                return citations.length - i;
            }
        }
        return 0;
    }
}

//bucket sort
public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
         
        int n = citations.length;
        int[] buckets = new int[n + 1];
         
        // Step 1: Accmulate the number of citations for each bucket
        for (int i = 0; i < n; i++) {
            if (citations[i] <= n) {
                buckets[citations[i]]++; 
            } else {
                buckets[n]++;
            }
        }
         
        // Step 2: iterate the citations from right to left.
        int numPapers = 0;
        for (int i = n; i >= 0; i--) {
            numPapers += buckets[i];
            if (numPapers >= i) {
                return i;
            }
        }
         
        return 0;
    }
}
