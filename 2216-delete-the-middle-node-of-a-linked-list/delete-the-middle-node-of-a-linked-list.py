# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = head
        p = dummy
        count = 0
        
        while dummy:
            count += 1
            dummy = dummy.next
        
        if count == 1 or count == 0:
            return None
        
        mid = count // 2
        index = 0
        ans = p
        
        while True:
            if mid == index + 1:
                p.next = p.next.next
                break
            p = p.next
            index += 1
        
        return ans
            