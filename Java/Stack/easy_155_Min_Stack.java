/***
Tags: Stack, Design
Create: 2019/5/20
Update: 2019/5/20

Problem description:

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.


Example:
	MinStack minStack = new MinStack();
	minStack.push(-2);
	minStack.push(0);
	minStack.push(-3);
	minStack.getMin();   --> Returns -3.
	minStack.pop();
	minStack.top();      --> Returns 0.
	minStack.getMin();   --> Returns -2.

***/

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


// Stack Version (idea from sometimescrazy)
// Runtime: 46 ms (faster than 91.61%); Memory Usage: 39.4 MB (less than 70.59%)

class MinStack {
    Stack<Integer> stack;
    int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if(x <= min){
            // If x smaller than min, changing min value and push in stack .
            // Because min is the smallest number till this step.
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        // If top value is same as min, the value under top number that is the smallest in the stack.
        if(stack.pop() == min)  min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}


// My First Version (Array)
// Runtime: 48 ms (faster than 71.52%); Memory Usage: 39.3 MB (less than 70.63%)

class MinStack {
    int min = Integer.MAX_VALUE, ptr = 0, i;
    int[] stack;
    
    public MinStack() {
        stack = new int[20];
    }

    public void push(int x) {
        if(ptr == stack.length) 
            stack = Arrays.copyOf(stack, stack.length * 2);
        
        if(x < min)    min = x;
        stack[ptr++] = x;
        
    }

    public void pop() {
        
        if(stack[ptr - 1] == min) {
            min = stack[0];
            for(i = 1; i <= ptr - 2; i++){
                if(stack[i] < min)  min = stack[i];
            }
        }
        --ptr;
        if(ptr == 0)    min = Integer.MAX_VALUE;
    }

    public int top() {
        return stack[ptr - 1];
    }

    public int getMin() {
        return min;
    }
}
