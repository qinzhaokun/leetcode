/*
Design a data structure that supports all following operations in average O(1) time.

Note: Duplicate elements are allowed.
insert(val): Inserts an item val to the collection.
remove(val): Removes an item val from the collection if present.
getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
Example:

// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection();

// Inserts 1 to the collection. Returns true as the collection did not contain 1.
collection.insert(1);

// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
collection.insert(1);

// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
collection.insert(2);

// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
collection.getRandom();

// Removes 1 from the collection, returns true. Collection now contains [1,2].
collection.remove(1);

// getRandom should return 1 and 2 both equally likely.
collection.getRandom();
*/


public class RandomizedCollection {

    /** Initialize your data structure here. */
    private Map<Integer,List<Integer>> map;
    private List<Integer> list;
    private int total;
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        total = 0;
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        if(map.containsKey(val)){
            List<Integer> value = map.get(val);
            value.add(total++);
            map.put(val,value);
            return false;
        }
        else{
            List<Integer> value = new ArrayList<>();
            value.add(total++);
            map.put(val,value);
            return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
            List<Integer> t = map.get(val);
            int value = t.get(t.size()-1);
            removeOne(value);
            if(t.size() == 1){
                map.remove(val);
            }
            else{
                t.remove(t.size()-1);
                map.put(val,t);
            }
            total--;
            return true;
        }
        else{
            return false;
        }
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int v = new Random().nextInt(total);
        return list.get(v);
    }
    
    public void removeOne(int value){
        //remove value of value from list
                if(value != list.size()-1) {
                    int last = list.get(list.size()-1);
                    list.set(value,last);
                    
                    //update back to hashMap
                    List<Integer> tt = map.get(last);
                    for(int i = 0;i < tt.size();i++){
                        if(tt.get(i) == list.size()-1){
                            tt.set(i,value);
                            break;
                        }
                    }
                    map.put(last,tt);
                    
                    
                }
                list.remove(list.size()-1);
                
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
