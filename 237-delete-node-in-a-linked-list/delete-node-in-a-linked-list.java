/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        int temp = 0;
        ListNode sl=null;
        while(node.next!=null){
            temp = node.next.val;
            node.val = temp;
            sl=node;
            node = node.next;
            
        }
        sl.next=null;
    }
}