/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].
*/

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List re = new ArrayList<>();
        re.add(1);
        for(int i = 1;i <= rowIndex;i++){
            for(int j = i-1;j >= 1;j--){
                re.set(j,(int)re.get(j-1)+(int)re.get(j));
            }
            re.add(1);
        }
        return re;
    }
}
