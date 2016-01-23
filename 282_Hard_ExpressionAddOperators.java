/*
Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples: 
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
*/

public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> re = new ArrayList<>();
        if(num == null || num.length() == 0){
            return re;
        }
        helper(num, target, "", 0, 0, re);
        return re;
    }
    
    void helper(String num, int target, String now, long cur, long pre, List<String> re){
        // 如果计算结果等于目标值，且所有数都用完了，则是有效结果
        if(num.length() == 0 && cur == target){
            re.add(now);
            return;
        }
        // 搜索所有可能的拆分情况
        for(int i = 1;i <= num.length();i++){
            long tmp = Long.parseLong(num.substring(0,i));
            // 第一个数，避免出现+1,+2
            if(now.length() == 0){
                helper(num.substring(i), target, num.substring(0,i), tmp,tmp,re);
            }
            else{
                // 乘法
                helper(num.substring(i), target, now+"*"+num.substring(0,i), cur-pre+pre*tmp,pre*tmp,re);
                // 加法
                helper(num.substring(i), target, now+"+"+num.substring(0,i), cur+tmp,tmp,re);
                // 减法
                helper(num.substring(i), target, now+"-"+num.substring(0,i), cur-tmp,-tmp,re);
            }
            
            // 对于前导为0的数予以排除
            if(tmp == 0){
                return;
            }
        }
    }
}
