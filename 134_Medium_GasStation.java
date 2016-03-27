/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
*/

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n = gas.length;
        int [] a = new int [n];
        int total = 0;
        for(int i = 0;i < n;i++) {a[i] = gas[i]-cost[i];total += a[i];}
        if(total < 0) return -1;
        int start = 0;
        int now = a[0];
        for(int i = 0;i < n;i++){
            if(a[i] >= 0){
                int sum = a[i];
                int j = i+1;
                for(;j%n != i;j++){
                    sum += a[j%n];
                    if(sum < 0) break;
                }
                if(j%n == i) return i;
                else{
                    if(j >=n) return -1;
                    else i = j;
                }
            }
        }
        return -1;
    }
}
