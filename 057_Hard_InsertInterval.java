/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
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
    //这道题跟Merge Intervals很类似，都是关于数据结构interval的操作。事实上，Merge Intervals是这道题的子操作，就是插入一个interval，如果出现冲突了，就进行merge。跟Merge Intervals不一样的是，这道题不需要排序，因为插入之前已经默认这些intervals排好序了。简单一些的是这里最多只有一个连续串出现冲突，因为就插入那么一个。基本思路就是先扫描走到新的interval应该插入的位置，接下来就是插入新的interval并检查后面是否冲突，一直到新的interval的end小于下一个interval的start，然后取新interval和当前interval中end大的即可。因为要进行一次线性扫描，所以时间复杂度是O(n)。而空间上如果我们重新创建一个ArrayList返回，那么就是O(n)。有朋友可能会说为什么不in-place的进行操作，这样就不需要额外空间，但是如果使用ArrayList这个数据结构，那么删除操作是线性的，如此时间就不是O(n)的。如果这道题是用LinkedList那么是可以做到in-place的，并且时间是线性的
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> re = new ArrayList<Interval>();
        int i = 0;
        while(i < intervals.size() && intervals.get(i).end < newInterval.start){
            re.add(intervals.get(i));
            i++;
        }
        
        if(i < intervals.size()){
            newInterval.start = Math.min(intervals.get(i).start,newInterval.start);
        }
        while(i < intervals.size() && intervals.get(i).start <= newInterval.end){
            newInterval.end = Math.max(intervals.get(i).end,newInterval.end);
            i++;
        }
        re.add(newInterval);
        while(i < intervals.size()){
            re.add(intervals.get(i));
            i++;
        }
        return re;
    }
}
