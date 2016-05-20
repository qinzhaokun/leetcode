/*
Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
Given the list [1,[4,[6]]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].

Subscribe to see which companies asked this question
*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    List<NestedInteger> nestedList;
    int i = 0;
    int max = 0;
    boolean inList = false;
    NestedIterator ite;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        i = 0;
        this.max = nestedList.size();
    }

    @Override
    public Integer next() {
        NestedInteger tmp = nestedList.get(i);
        if(tmp.isInteger()) {i++;return tmp.getInteger();}
        else{
            
            if(!inList){
                List<NestedInteger> other = tmp.getList();
                ite = new NestedIterator(other);
                inList = true;
            }
            
            if(ite.hasNext()) return ite.next();
            else{
                inList = false;
                i++;
                return next();
            }
            
        }
    }

    @Override
    public boolean hasNext() {
        if(inList){
            if(ite.hasNext()) return true;
            else {
                if(i+1 == max) return false;
                else{
                    if(nestedList.get(i+1).isInteger()) return true;
                    else{
                        if(new NestedIterator(nestedList.get(i+1).getList()).hasNext()) return true;
                        else{
                            i++;
                            return hasNext();
                        }
                    }
                }
            }
        }
        //else return i != max;
        if(i == max) return false;
        if(nestedList.get(i).isInteger()) return true;
        else{
            if(new NestedIterator(nestedList.get(i).getList()).hasNext()) return true;
            else{
                i++;
                return hasNext();
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
 
 
 /**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size()-1;i >= 0;i--){
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()){
            if(stack.peek().isInteger()) return true;
            List<NestedInteger> nestedList = stack.pop().getList();
            for(int i = nestedList.size()-1;i >= 0;i--){
                stack.push(nestedList.get(i));
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
