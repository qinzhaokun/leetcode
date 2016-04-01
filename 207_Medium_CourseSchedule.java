/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
*/


public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [][] graph = new int [numCourses][numCourses];
        int [] degree = new int [numCourses];
        for(int i = 0;i < prerequisites.length;i++){
            //process duplicate case, other than , wrong answer
            if(graph[prerequisites[i][1]][prerequisites[i][0]] == 0) degree[prerequisites[i][0]]++;
            graph[prerequisites[i][1]][prerequisites[i][0]] = 1;
            
        }
        
        boolean [] out = new boolean [numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i < numCourses;i++){
            if(!out[i] && degree[i] == 0){
                queue.add(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int now = queue.poll();
            count++;
            out[now] = true;
            for(int i = 0;i < numCourses;i++){
                if(!out[i] && graph[now][i] == 1){
                    degree[i]--;
                    if(degree[i] == 0) queue.add(i);
                }
            }
        }
        
        return count == numCourses ? true : false;
    }
}
