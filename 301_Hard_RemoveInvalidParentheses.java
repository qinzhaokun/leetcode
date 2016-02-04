/*
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]
/*

//DFS
public class Solution {
    private int max;
    public List<String> removeInvalidParentheses(String s) {
        max = -1;
        List<String> re = new ArrayList<>();
        dfs("",s,0,0,re);
        return re;
    }
    
    void dfs(String org, String now, int left, int right,List re){
        if(now.length() == 0){
            if(left == right){
                if(max == -1){
                    max = org.length();
                }
                if(max == org.length() && !re.contains(org)){
                    re.add(org);
                }
                
            }
            else{
                return;
            }
        }
        else{
            if(org.length() + now.length() < max){
                return;
            }
            if(now.charAt(0) == '('){
                dfs(org+'(',now.substring(1),left+1,right,re);
                dfs(org,now.substring(1),left,right,re);
            }
            else if(now.charAt(0) == ')'){
                
                if(right+1<=left){
                    dfs(org+')',now.substring(1),left,right+1,re);
                }
                dfs(org,now.substring(1),left,right,re);
            }
            else{
                dfs(org+now.charAt(0),now.substring(1),left,right,re);
            }
        }
    }
}

//BFS
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
      List<String> res = new ArrayList<>();

      // sanity check
      if (s == null) return res;

      Set<String> visited = new HashSet<>();
      Queue<String> queue = new LinkedList<>();

      // initialize
      queue.add(s);
      visited.add(s);

      boolean found = false;

      while (!queue.isEmpty()) {
        s = queue.poll();

        if (isValid(s)) {
          // found an answer, add to the result
          res.add(s);
          found = true;
        }

        if (found) continue;

        // generate all possible states
        for (int i = 0; i < s.length(); i++) {
          // we only try to remove left or right paren
          if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;

          String t = s.substring(0, i) + s.substring(i + 1);

          if (!visited.contains(t)) {
            // for each state, if it's not visited, add it to the queue
            queue.add(t);
            visited.add(t);
          }
        }
      }

      return res;
    }

    // helper function checks if string s contains valid parantheses
    boolean isValid(String s) {
      int count = 0;

      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '(') count++;
        if (c == ')' && count-- == 0) return false;
      }

      return count == 0;
    }
}
