# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def insertGreatestCommonDivisors(self, head: Optional[ListNode]) -> Optional[ListNode]:
        node = head
        while node.next is not None:
            current = node
            next_node = node.next
            max_value = max(current.val, next_node.val)
            min_value = min(current.val, next_node.val)
            new_node = ListNode(gcd(max_value, min_value), next_node)
            current.next = new_node
            node = next_node
        return head
            
    def gcd(a, b) -> int:
        if b is 0 : 
            return a
        return gcd(b, a%b)