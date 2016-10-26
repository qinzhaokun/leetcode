public class Solution {
    public int lengthLongestPath(String input) {
        List<Integer> list = new ArrayList();
        String [] a = input.split("\\n");
        int count = 0;
        int max = 0;
        int localMax = 0;
        for(int i = 0;i < a.length;i++){
            if(a[i].length() == 0) continue;
            int c = 0;int j = 0;
            for(;j < a[i].length();j++){
                if(a[i].charAt(j) == '\t') c++;
                else break;
            }
            int l = a[i].length()-j+1;
            if(list.size() == c){
                list.add(l);
                localMax += l;
            }
            else{
                while(list.size() != c){
                    int last = list.get(list.size()-1);
                    list.remove(list.size()-1);
                    localMax -= last;
                }
                list.add(l);
                localMax += l;
            }
            if(a[i].contains(".") && localMax-1 > max) max = localMax - 1;
        }
        return max;
    }
}
