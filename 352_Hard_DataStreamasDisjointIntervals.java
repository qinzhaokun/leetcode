/*
Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.

For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

[1, 1]
[1, 1], [3, 3]
[1, 1], [3, 3], [7, 7]
[1, 3], [7, 7]
[1, 3], [6, 7]
Follow up:
What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
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
 class Tree {
     Interval interval;
     Tree left;
     Tree right;
     
     Tree(int num) {interval = new Interval(num,num);}
 }
 
public class SummaryRanges {

    /** Initialize your data structure here. */
    Tree root;
    public SummaryRanges() {
        
    }
    
    public void addNum(int val) {
        if(root == null) root = new Tree(val);
        else add(root,val);
    }
    
    public void add(Tree now,int val){
        if(now.interval.start <= val && val <= now.interval.end) return;
        else if(now.interval.start == val+1){
            now.interval.start = val;
            Tree parent = now;
            Tree find = now.left;
            while(find != null && find.right != null) {parent = find;find = find.right;}
            if(find != null && (find.interval.end == now.interval.start || find.interval.end+1 == now.interval.start)){
                now.interval.start = find.interval.start;
                if(parent == now) parent.left = find.left;
                else parent.right = find.left;
            }
        }
        else if(now.interval.end + 1 == val){
            now.interval.end = val;
            Tree parent = now;
            Tree find = now.right;
            while(find != null && find.left != null){parent = find;find = find.left;}
            if(find != null &&  (find.interval.start == now.interval.end || find.interval.start-1 == now.interval.end)){
                now.interval.end = find.interval.end;
                if(parent == now) parent.right = find.right;
                else parent.left = find.right;
            }
        }
        else if(now.interval.start > val){
            if(now.left == null) now.left = new Tree(val);
            else add(now.left,val);
        }
        else{
            if(now.right == null) now.right = new Tree(val);
            else add(now.right,val);
        }
    }
    
    public List<Interval> getIntervals() {
        List ret = new ArrayList();
        inOrder(root,ret);
        return ret;
    }
    
    public void inOrder(Tree now, List ret){
        if(now != null){
            inOrder(now.left,ret);
            ret.add(now.interval);
            inOrder(now.right,ret);
        }
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
