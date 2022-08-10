class MyStack {
    
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    
    int size = 0;
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        queue1.add(x);
        size++;
    }
    
    public int pop() {
        if (size < 1) {
            return queue1.poll();
        } else if (size == 1) {
            size--;
            return queue1.poll();
        }

        for (int i = 0; i < size - 1; i++) {
            queue2.add(queue1.poll());
        }
        size--;
        Queue<Integer> tempQueue = queue1;
        queue1 = queue2;
        queue2 = new LinkedList<>();
        return tempQueue.poll();
    }
    
    public int top() {
        if (size < 1) {
            return queue1.peek();
        } else if (size == 1) {
            return queue1.peek();
        }
        
        for (int i = 0; i < size - 1; i++) {
            queue2.add(queue1.poll());
        }
        queue2.add(queue1.peek());
        Queue<Integer> tempQueue = queue1;
        queue1 = queue2;
        queue2 = new LinkedList<>();
        return tempQueue.peek();
    }
    
    public boolean empty() {
        return queue1.isEmpty();
    }
}
