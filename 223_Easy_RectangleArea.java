/*
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.
*/

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int i = Math.max(A,E);
        int j = Math.min(C,G);
        int k = Math.max(B,F);
        int t = Math.min(D,H);
        int area = 0;
        if(i >= j || k >= t){
            area = 0;
        }
        else{
            area = (j-i)*(t-k);
        }
        return (C-A)*(D-B) + (G-E)*(H-F) - area;
    }
}
