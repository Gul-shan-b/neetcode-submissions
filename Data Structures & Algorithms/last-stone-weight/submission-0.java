class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

       
        for(int i:stones){
            heap.add(i);
                 
            
        }
        while(heap.size()>1){
            int x = heap.poll();
            int y = heap.poll();
            if(x!=y){
                heap.add(x-y);
            }
            if(heap.isEmpty()){
                return 0;
            }
        }
        return heap.peek();
        
    }
}
