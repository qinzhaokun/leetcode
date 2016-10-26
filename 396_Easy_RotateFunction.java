public class Solution {
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        for(int i = 0;i < A.length;i++){
            sum += A[i];
        }
        int base = 0;
        for(int i = 0;i < A.length;i++){
            base += i*A[i];
        }
        int max = base;
        for(int i = A.length-1;i > 0;i--){
            base = base + (sum-A[i])-(A.length-1)*A[i];
            if(base > max) max = base;
        }
        return max;
    }
}
