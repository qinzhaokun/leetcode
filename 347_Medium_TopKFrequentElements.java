/*
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num))map.put(num,map.get(num)+1);
            else map.put(num,1);
        }

        int [][] arr = new int [2][map.size()];
        Iterator iter = map.entrySet().iterator();

        int count = 0;
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            arr[0][count++] = (int)entry.getKey();
            arr[1][count-1] = (int)entry.getValue();
        }

            int index = findK(arr,0,arr[0].length-1,k);
            List ret = new ArrayList<>();
            for(int i = 0;i < k;i++) ret.add(arr[0][i]);
            return ret;

    }

    int findK(int [][] arr, int l, int r, int k){
        if(r-l+1 == k) return r;
        int var = arr[1][l];
        int j = l;
        for(int i = l+1;i <= r;i++){
            if(arr[1][i] >= var && j+1 != i){
                swap(arr,j+1,i);
                j++;
            }
        }
        if(j != l){
            swap(arr,j,l);
        }
        if(j-l == k-1) return j;
        else if(j-l < k-1) return findK(arr, j + 1, r, k - (j - l + 1));
        else return findK(arr,l,j-1,k);
    }

    void swap(int [][] arr, int i, int j){
        int tmp = arr[0][i];
        arr[0][i] = arr[0][j];
        arr[0][j] = tmp;
        tmp = arr[1][i];
        arr[1][i] = arr[1][j];
        arr[1][j] = tmp;
    }
}

public List<Integer> topKFrequent(int[] nums, int k) {

    List<Integer>[] bucket = new List[nums.length + 1];
    Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

    for (int n : nums) {
        frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
    }

    for (int key : frequencyMap.keySet()) {
        int frequency = frequencyMap.get(key);
        if (bucket[frequency] == null) {
            bucket[frequency] = new ArrayList<>();
        }
        bucket[frequency].add(key);
    }

    List<Integer> res = new ArrayList<>();

    for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
        if (bucket[pos] != null) {
            res.addAll(bucket[pos]);
        }
    }
    return res;
}
