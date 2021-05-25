/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // idea: keep popping based on lowest, iterate through each first val and track min to do this o(3*n)
        // another idea: use priority queue to automatically sort, one pass add all nodes to queue, pop all from queue in order and link in list
        if (lists == null || lists.length < 1) {
            return null;
        }
        ListNode curr = new ListNode();
        ListNode head = curr;
        
        Queue<ListNode> pQueue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            ListNode n = lists[i];
            while (n != null) {
                pQueue.offer(n);
                n = n.next;
            }
        }
        // System.out.println(pQueue);
        while (pQueue.size() > 0) {
            curr.next = pQueue.poll();
            curr = curr.next;
            curr.next = null;
        }
        return head.next;
    }
}