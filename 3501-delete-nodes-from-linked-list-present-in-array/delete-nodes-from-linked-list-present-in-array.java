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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> hs = new HashSet<>();
        for(int x:nums){
            hs.add(x);
        }
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode curr = head;
        ListNode prev = ans;

        while(curr!=null){
            if(hs.contains(curr.val)){
                prev.next = curr.next;
                // curr = curr.next;
            }
            else{
                prev = curr;
            }
            
            curr = curr.next;
        }
        return ans.next;
        
    }
}