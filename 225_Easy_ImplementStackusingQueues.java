/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack)
*/

class MyStack {
    Queue<Integer> q1 = new LinkedList<Integer>();  
    Queue<Integer> q2 = new LinkedList<Integer>(); 
    int top;
    // Push element x onto stack.
    public void push(int x) {
        top = x;
        q1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while(q1.size() > 2){
            q2.offer(q1.poll());
        }
        if(q1.size() == 2){
            top = q1.poll();
            q2.offer(top);
            q1.poll();
            
        }
        else{
            q1.poll();
            top = 0;
        }
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    // Get the top element.
    public int top() {
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}
