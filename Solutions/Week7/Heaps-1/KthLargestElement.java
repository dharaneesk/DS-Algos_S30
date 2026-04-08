// Time Complexity : O(n)
// Space Complexity : O(log k) - min heap// max O(log (n-k))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Add the elements to minHeap PQ with size of k
// PQ will make sure to maintain the last k largest elements in Heap
// pq peek will have the kth largest element

public class KthLargestElement {

    // Using Frequency Array O(n) time and O(n) space
     public int findKthLargestUsingFrequency(int[] nums, int k) {
        int max = nums[0], min = nums[0];
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }

        int[] count = new int[max-min+1];
        for(int i=0;i<nums.length;i++){
            count[nums[i]-min]++;
        }

        int i;
        for(i=max-min;i>=0;i--){
            k -= count[i]; 
            if(k <= 0) break;
        }

        return i+min;
    }

    // Quickselect Amortised O(n) and worst case O(n^2)
    private int quickselect(List<Integer> nums, int k){
        int index = new Random().nextInt(nums.size());
        int pivot = nums.get(index);

        List<Integer> left = new ArrayList();
        List<Integer> mid = new ArrayList();
        List<Integer> right = new ArrayList();

        for(int num:nums){
            if(num > pivot)
                left.add(num);
            else if(num < pivot)
                right.add(num);
            else
                mid.add(num);
        }

        if(k <= left.size())
            return quickselect(left,k);
        else if(k > left.size() + mid.size())
            return quickselect(right, k - (left.size()+mid.size()));
        
        return pivot;
    }

    public int findKthLargest2(int[] nums, int k) {

        //Using Max Heap
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue(
            new Comparator<Integer> () {
                public int compare(Integer a, Integer b) {
                    return b - a;
                }
            }
        );

        for(int i =0;i<n;i++){
            pq.add(nums[i]);
            if(pq.size()>n-k){
                result = Math.min(pq.poll(),result);
            }
        }

        return result;
    }

    public int findKthLargest(int[] nums, int k) {
        
        //Using Min Heap
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue();

        for(int i =0;i<n;i++){
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }

        return pq.peek();
    }
}
