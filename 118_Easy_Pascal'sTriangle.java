/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> re = new ArrayList<>();
        for(int i = 0;i < numRows;i++){
            if(re.isEmpty()){
                List tmp = new ArrayList<>();
                tmp.add(1);
                re.add(tmp);
            }
            else{
                List last = (List)re.get(re.size()-1);
                List tmp = new ArrayList<>();
                tmp.add(1);
                for(int j = 1;j < last.size();j++){
                    tmp.add((int)last.get(j)+(int)last.get(j-1));
                }
                tmp.add(1);
                re.add(tmp);
            }
        }
        return re;
    }
}
