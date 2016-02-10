/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Subscribe to see which companies asked this question
*/

class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();
    public void push(int x) {
        stack.push(x);
        //当x > min.peek() 时，x可不用放进min,因为在stack中，此时min.peek()比x先进，必然比x后出，所以，若将来弹出x后，最小不会变
        if(min.isEmpty() || min.peek() >= x){
            min.push(x);
        }
    }

    public void pop() {
        //对象要用object
        if(stack.peek().equals(min.peek())){
            stack.pop();
            min.pop();
        }
        else{
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
