/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        int n = intervals.size();
        return mergesort(intervals);
    }
    
    List<Interval> mergesort(List<Interval> intervals){
        int n = intervals.size();
        if(n == 0 || n == 1){
            return intervals;
        }
        else{
            int mid = n/2;
            List<Interval> left = mergesort(intervals.subList(0,mid));
            List<Interval> right = mergesort(intervals.subList(mid,n));
            return merge(left,right);
        }
    }
    
    List<Interval> merge(List<Interval> left, List<Interval> right){
        List<Interval> tmp = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < left.size() && j < right.size()){
            if(left.get(i).start < right.get(j).start){
                if(left.get(i).end < right.get(j).start){
                    tmp.add(left.get(i));
                    i++;
                }
                else{
                    if(left.get(i).end >= right.get(j).end){
                        j++;
                    }
                    else{
                        right.get(j).start = left.get(i).start;
                        i++;
                    }
                }
            }
            else{
                if(right.get(j).end < left.get(i).start){
                    tmp.add(right.get(j));
                    j++;
                }
                else{
                    if(right.get(j).end >= left.get(i).end){
                        i++;
                    }
                    else{
                        left.get(i).start = right.get(j).start;
                        j++;
                    }
                }
            }
        }
        
        while(i != left.size()){
            tmp.add(left.get(i));
            i++;
        }
        while(j != right.size()){
            tmp.add(right.get(j));
            j++;
        }
        return tmp;
    }
}
