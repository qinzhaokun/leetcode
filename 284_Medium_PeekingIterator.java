/*
Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().


Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].

Call next() gets you 1, the first element in the list.

Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.

You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.

*/

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    boolean flag = false;
    Integer tmp = 0;
    Iterator<Integer> iterator = null;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    flag = false;
	    this.iterator = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
	    if(flag){
	        return tmp;
	    }
	    else{
	        tmp = iterator.next();
	        flag = true;
            return tmp;
	    }
	    
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(flag){
	        flag = false;
	        return tmp;
	    }
	    else{
	        return iterator.next();
	    }
	}

	@Override
	public boolean hasNext() {
	    if(flag){
	        return true;
	    }
	    else{
	        return iterator.hasNext();
	    }
	}
}
