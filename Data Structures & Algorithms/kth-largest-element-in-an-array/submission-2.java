class Solution {
    PriorityQueue<Integer> heap;
    int k;
    public int findKthLargest(int[] nums, int k) {
        //this.k =k;
        heap = new PriorityQueue<>();
        for(int i : nums){
            heap.add(i);
            if(heap.size()>k){
                heap.poll();
            }
        }
        return heap.peek();
        
        
    }
}
