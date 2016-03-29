/*
Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
*/

public class Solution {
    public int compareVersion(String version1, String version2) {
        //1:如果用“.”作为分隔的话,必须是如下写法,String.split("\\."),这样才能正确的分隔开,不能用String.split(".");

        //2:如果用“|”作为分隔的话,必须是如下写法,String.split("\\|"),这样才能正确的分隔开,不能用String.split("|");

        //“.”和“|”都是转义字符,必须得加"\\";
        String [] v1 = version1.split("\\.");
        String [] v2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        while(i < v1.length || j < v2.length){
            if(i < v1.length && j < v2.length){
                if((int)Integer.valueOf(v1[i]) > (int)Integer.valueOf(v2[j])){
                    return 1;
                }
                else if(Integer.valueOf(v1[i]) < Integer.valueOf(v2[j])){
                    return -1;
                }
            }
            else if(i >= v1.length){
                //陷阱
                if((int)Integer.valueOf(v2[j]) != 0){
                    return -1;
                }
                
            }
            else if(j >= v2.length){
                //陷阱
                if((int)Integer.valueOf(v1[i]) != 0){
                    return 1;
                }
            }
            i++;
            j++;
        }
        return 0;
    
    }
}
