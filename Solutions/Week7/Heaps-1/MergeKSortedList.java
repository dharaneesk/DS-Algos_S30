// Time Complexity : O(N log k) -> k is number of Linkedlist and N (=n*k) is total number of elements
// Space Complexity : O(log k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Add the heads of each LL to a PQ. 
// Poll and get the min value out of heads and store it in a result LL. 
// Take the next element of the polled LL and add to the PQ.
// Repeat till all elements are added to PQ and polled

public class MergeKSortedList {

    public ListNode mergeKListsSorting(ListNode[] lists) {
        List<ListNode> result = new ArrayList();
        for(ListNode head:lists){
            while(head!=null){
                result.add(head);
                head = head.next;
            }
        }

        Collections.sort(result, (a,b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for(ListNode node: result){
            curr.next = node;
            curr = curr.next;
        }

        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue(
            new Comparator<ListNode> () {
                public int compare(ListNode a, ListNode b) {
                    return a.val - b.val;
                }
            }
        );

        for(ListNode head : lists){
            if(head != null)
                pq.add(head);
        }

        while (!pq.isEmpty()) {
            curr.next = pq.poll();
            curr = curr.next;
            if(curr.next != null)
                pq.add(curr.next);
        }

        return dummy.next;
    }
}
