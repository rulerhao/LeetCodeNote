class MedianFinder {

    PriorityQueue<Integer> smallHeap;
    PriorityQueue<Integer> largeHeap;
    
    public MedianFinder() {
        largeHeap = new PriorityQueue<>((a, b) -> a - b);
        smallHeap = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        smallHeap.add(num);
        if (
            smallHeap.size() - largeHeap.size() > 1 ||
            !largeHeap.isEmpty() &&
            smallHeap.peek() > largeHeap.peek()
        ) {
            largeHeap.add(smallHeap.poll());
        }
        if (largeHeap.size() - smallHeap.size() > 1) {
            smallHeap.add(largeHeap.poll());
        }
    }
    
    public double findMedian() {
        if (smallHeap.isEmpty() && largeHeap.isEmpty()) {
            return 0;
        } else if (smallHeap.size() > largeHeap.size()) {
            return smallHeap.peek();
        } else if (smallHeap.size() < largeHeap.size()) {
            return largeHeap.peek();
        } else {
            return (smallHeap.peek() + largeHeap.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
