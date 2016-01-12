/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/

class Solution {
public:
    vector<int> twoSum(vector<int> &numbers, int target) {
        int i, sum;
        vector<int> results;
        map<int, int> hmap;
        for(i=0; i<numbers.size(); i++){
            if(!hmap.count(numbers[i])){
                hmap.insert(pair<int, int>(numbers[i], i));
            }
            if(hmap.count(target-numbers[i])){
                int n=hmap[target-numbers[i]];
                if(n<i){
                    results.push_back(n+1);
                    results.push_back(i+1);
                    //cout<<n+1<<", "<<i+1<<endl;
                    return results;
                }

            }
        }
        return results;
    }
};
