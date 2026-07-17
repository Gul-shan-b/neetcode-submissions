class Solution {
    PriorityQueue<Integer> heap;
    
    public int findKthLargest(int[] nums, int k) {
        
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
