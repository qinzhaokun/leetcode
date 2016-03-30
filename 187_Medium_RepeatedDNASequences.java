/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
*/

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List re = new ArrayList();
        int mark = 0;
        for(int i = 0;i < 10;i++){
            mark = mark << 2;
            mark += 3;
        }
        int num = 0;
        if(s.length() >= 10){
            for(int j = 0;j < 10;j++){
                num = num << 2;
                int count = 0;
                if(s.charAt(j) == 'C') count = 1;
                else if(s.charAt(j) == 'G') count = 2;
                else if(s.charAt(j) == 'T') count = 3;
                num  = num | count;
            }
        }
        Set map = new HashSet();
        map.add(num);
        for(int i = 10;i < s.length();i++){
            num = num << 2;
            int count = 0;
            if(s.charAt(i) == 'C') count = 1;
            else if(s.charAt(i) == 'G') count = 2;
            else if(s.charAt(i) == 'T') count = 3;
            num  = num | count;
            num = num & mark;
            if(map.contains(num) && !re.contains(s.substring(i-9,i+1))) {re.add(s.substring(i-9,i+1));}
            else map.add(num);
        }
        return re;
    }
}
