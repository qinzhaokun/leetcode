/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

//standard solution
public class Solution {
    public String convert(String s, int numRows) {
        StringBuffer [] sc = new StringBuffer [numRows];
        for(int i = 0;i < numRows;i++){
            sc[i] = new StringBuffer();
        }
        int i = 0;
        while(i < s.length()){
            for(int j = 0;j < numRows && i < s.length();j++){
                sc[j].append(s.charAt(i++));
            }
            for(int j = numRows-2;j > 0 && i < s.length();j--){
                sc[j].append(s.charAt(i++));
            }
        }
        for(int j = 1;j < numRows;j++){
            sc[0].append(sc[j]);
        }
        return sc[0].toString();
    }
}

//my solution
public class Solution {
    public String convert(String s, int numRows) {
        int n= s.length();
        int count = 0;
        int len = numRows+numRows-2;
        char [] a = new char[n];
        if (n==0 ||len==0) {
            return s;
        }
        int k = n/len;
        for (int j=0;j<numRows;j++) {
        	if(j==0||j==numRows-1) {
        		for (int i=0;i<=k;i++) {
        			if (i*len+j < n) {
        			a[count]=s.charAt(i*len+j);
        			count++;
        			}
        		}
        	}
        	else {
        		for (int i=0;i<=k;i++) {
        			if (i*len+j < n) {
        				a[count]=s.charAt(i*len+j);
        				count++;
        			}
        			if (i*len+len-j <n) {
        				a[count]=s.charAt(i*len+len-j);
        				count++;
        			}
        	}
        	
        	
        	}
        }

		return new String(a);
    }
}
