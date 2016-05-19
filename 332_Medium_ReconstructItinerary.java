/*
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
*/

public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue> map = new HashMap<>();
        
        for(int i = 0;i < tickets.length;i++){
            if(!map.containsKey(tickets[i][0])){
                PriorityQueue pq = new PriorityQueue();
                map.put(tickets[i][0],pq);
            }
            
            PriorityQueue pq = map.get(tickets[i][0]);
            pq.add(tickets[i][1]);
            map.put(tickets[i][0],pq);
        }
        
        List ret = new ArrayList();
        dfs(map,"JFK",ret);
        Collections.reverse(ret);
        return ret;
    }
    
    void dfs(Map<String, PriorityQueue> map,String from, List ret){
        if(map.containsKey(from)){
           PriorityQueue pq = map.get(from);
           while(!pq.isEmpty()){
               String to = (String)pq.poll();
               dfs(map,to,ret);
           }
        }
        ret.add(from);
    }
}
