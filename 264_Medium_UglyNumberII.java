/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.

Hint:

The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
*/

//my solution, low speed
public class Solution {
    List<Integer> re = new ArrayList<>();
    public int nthUglyNumber(int n) {
        if(re.size() == 0){
            re.add(1);
            re.add(2);
            re.add(3);
            re.add(4);
            re.add(5);
        }
        if(n <= re.size()){
            return (int)re.get(n-1);
        }
        int i = re.size();
        while(i < n){
            int target = re.get(re.size()-1);
            int min = target*2;
            int now = min;
            int count = re.size()-1;
            while(now > target && count > 0){
                min = now;
                count--;
                now = re.get(count)*2;
            }
            if(count == 0){
                re.add(min);
                i++;
                continue;
            }
            now = re.get(count)*3;
            while(now > target && count > 0){
                min = Math.min(min,now);
                count--;
                now = re.get(count)*3;
            }
            if(count == 0){
                re.add(min);
                i++;
                continue;
            }
            now = re.get(count)*5;
            while(now > target && count > 0){
                min = Math.min(min,now);
                count--;
                now = re.get(count)*5;
            }
            re.add(min);
            i++;
        }
        return (int)re.get(re.size()-1);
    }
} 

//network solution
public class Solution {
    public int nthUglyNumber(int n) {
        int u = 0;
        List<Integer> l1 = new LinkedList<Integer>();
        List<Integer> l2 = new LinkedList<Integer>();
        List<Integer> l3 = new LinkedList<Integer>();
        l1.add(1);
        l2.add(1);
        l3.add(1);
        
        for(int i=0; i<n; i++) {
            u = Math.min( Math.min(l1.get(0), l2.get(0)), l3.get(0));
            
            if(l1.get(0) == u) l1.remove(0);
            if(l2.get(0) == u) l2.remove(0);
            if(l3.get(0) == u) l3.remove(0);
            
            l1.add(u*2);
            l2.add(u*3);
            l3.add(u*5);
        }
        return u;
    }
}
