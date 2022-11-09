class StockSpanner {

    Stack<int[]> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        if (st.isEmpty() || (!st.isEmpty() && st.peek()[0] > price)) {
            st.add(new int[]{price, 1});
            return 1;
        }
        
        int span = 1;
        while (!st.isEmpty() && st.peek()[0] <= price) {
            span += st.peek()[1];
            st.pop();
        }

        st.add(new int[]{price, span});

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
