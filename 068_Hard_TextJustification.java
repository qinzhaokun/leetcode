/*
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.
*/

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int i = 0;
        int sum = 0;
        List<String> re = new ArrayList<String>();
        if(maxWidth == 0){
        	re.add("");
        	return re;
        }
        for(int j = 0;j < words.length;j++){
            sum += words[j].length();
            if(sum+j-i > maxWidth){
                int empty = maxWidth-sum+words[j].length();
                re.add(makeString(words,i,j,empty,maxWidth));
                i = j;
                sum = words[j].length();
            }
        }
        String last = "";
        for(int k = i;k < words.length;k++){
        	last += words[k]+" ";
        }
        last = last.substring(0,last.length()-1);
        int l = maxWidth - last.length();
        StringBuilder sb = new StringBuilder();
        for(int k = 0;k < l;k++){
        	sb.append(" ");
        }
        last += sb.toString();
        re.add(last);
        return re;
    }
    
    public String makeString(String [] words, int i, int j,int empty, int max){
        int tmp = j-i-1;
        if(tmp == 0){
            StringBuilder sb = new StringBuilder();
            sb.append(words[i]);
            for(int k = 0;k < max-words[i].length();k++){
                sb.append(" ");
            }
            return sb.toString();
        }
        else{
            String re = "";
            for(int k = j-1;k >=i;k--){
                re = words[k] + re;
                if(tmp <= 0){
                    continue;
                }
                else{
                   int l = empty/tmp;
                   StringBuilder sb = new StringBuilder();
                   for(int t = 0;t < l;t++){
                       sb.append(" ");
                   }
                   re = sb.toString()+re;
                   empty -= l;
                   tmp--;
                }
                
            }
            return re;
        }
    }
}
