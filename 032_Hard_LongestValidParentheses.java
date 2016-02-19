/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/

//using stack
public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<Integer>();
        int res = 0;
        char[] ch = s.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i] == '(')
                stk.push(i);
            else{
                if(!stk.isEmpty() && ch[stk.peek()] == '('){
                    stk.pop();
                    res = Math.max(stk.isEmpty()?i+1:i-stk.peek() ,res );
                }
                else
                    stk.push(i);
            }
        }
        return res;
    }
  }
  
//using array
class Solution {
public:
    int longestValidParentheses(string s) {
        bool *a = new bool[s.length()];
        memset(a, false, s.length());
        stack<int> st;
        for (int i = 0; i < s.length(); ++i) {
            if (s[i] == '(') {
                st.push(i);
            } else if (s[i] == ')' && !st.empty()) {
                a[i] = true;
                a[st.top()] = true;
                st.pop();
            }
        }
        int max_len = 0, cur_len = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (a[i]) ++cur_len;
            else cur_len = 0;
            max_len = max(max_len, cur_len);
        }
        return max_len;
    }
};

//using dynamic programming
public class Solution {
    
    public int longestValidParentheses(String s) {
        //括号题也不是只用stack才能做，这题是算长度，所以stack那种一match就俩一起pop了的方式就不适合了。求极值，一维dp最好使。
//d[i]: 以i开头的最长valid parentheses有多长。
//d[i] =
//if  (str[i] == ‘)’)，以右括号开头必定invalid，d[i] = 0
//if (str[i] == ‘(‘)，以左括号开头
//我们想看对应的有木有右括号。因为d[i + 1]代表的sequence肯定是左括号开头右括号结尾，所以我们想catch((…))这种情况。j = i + 1 + d[i + 1]，正好就是str[i]后面越过完整sequence的下一个，若是右括号，d[i] = 2 + d[i + 1]

//除此之外，还有包起来后因为把后面的右括号用了而导致跟再往后也连起来了的情况，如((..))()()()。所以d[i]还要再加上j后面那一段的d[j + 1]
//这个定义和最长公共字串那题的定义类似，都是“以某个固定位置开始/结束”。看两头的方式又像palindrome。从后往前的一维dp也不常见。挺好玩的，一下复习好多东西。
//https://leetcodenotes.wordpress.com/2013/10/19/leetcode-longest-valid-parentheses-%E8%BF%99%E7%A7%8D%E6%8B%AC%E5%8F%B7%E7%BB%84%E5%90%88%EF%BC%8C%E6%9C%80%E9%95%BF%E7%9A%84valid%E6%8B%AC%E5%8F%B7%E7%BB%84%E5%90%88%E6%9C%89%E5%A4%9A/
        if(s == null || s.length() < 2){
            return 0;
        }
        int n = s.length();
        int [] a = new int [n];
        a[n-1] = 0;
        int sum = 0;
        for(int i = n-2;i >= 0;i--){
            if(s.charAt(i) == ')'){
                a[i] = 0;
            }
            else{
                int j = i+1+a[i+1];
                if(j < n && s.charAt(j)==')'){
                    a[i] = a[i+1] + 2;
                   if(j + 1 < s.length()){
                        a[i] += a[j+1];
                    } 
                }
                else{
                    a[i] = 0;
                }
                
                sum = Math.max(sum,a[i]);
            }
        }
        return sum;
    }
}
