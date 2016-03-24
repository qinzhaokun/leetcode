/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
*/

class Solution {
public:
    int ladderLength(string beginWord, string endWord, unordered_set<string>& wordList) {
        if(beginWord == endWord){
            return 1;
        }
        int n = beginWord.length();
        queue<string> queue;
        queue.push(beginWord);
        int count = 1;
        while(!queue.empty()){
            int len = queue.size();
            int i = 0;
            while(i < len){
                string tmp = queue.front();
                queue.pop();
                for(int j = 0;j < n;j++){
                    char key = tmp[j];
                    for(int t = 'a';t <= 'z';t++){
                        if(t != key) {
                            tmp[j] = t;
                            if(tmp == endWord){return count+1;}
                            if(wordList.count(tmp)) {wordList.erase(tmp);queue.push(tmp);}
                        }
                    }
                    tmp[j]=key;
                }
                i++;
            }
            count++;
        }
        return 0;
    }
};
