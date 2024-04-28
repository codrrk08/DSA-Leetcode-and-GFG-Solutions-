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
    public ListNode deleteMiddle(ListNode head) {
        ListNode dummy = head;
        ListNode p = dummy;
        int count = 0;
        while(dummy!=null){
            count++;
            dummy = dummy.next;
        }
        if(count==1||count==0)
        return null;
        int mid = count/2;
        int index = 0;
        ListNode ans = p;
        while(true){
            if(mid==index+1){
                p.next = p.next.next;
                break;
            }
            p = p.next;
            index++;
        }
        return ans;
        
    }
}