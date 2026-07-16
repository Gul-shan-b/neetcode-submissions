class KthLargest {
    PriorityQueue<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k =k;
        heap = new PriorityQueue<>();
        for(int i: nums){
            heap.add(i);
            if(heap.size() > k){
                heap.poll();
            }
        }

        
    }
    
    public int add(int val) {
        
        heap.add(val);
        if(heap.size()>k){
            heap.poll();
        }
        return heap.peek();
        
    }
}
