class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def spiralMatrix(self, rows: int, columns: int, head: Optional[ListNode]) -> List[List[int]]:
        # Initialize the matrix with -1
        matrix = [[-1] * columns for _ in range(rows)]
        
        top_row, bottom_row = 0, rows - 1
        left_column, right_column = 0, columns - 1
        
        while head:
            # Fill the top row (left to right)
            for col in range(left_column, right_column + 1):
                if not head:
                    return matrix
                matrix[top_row][col] = head.val
                head = head.next
            top_row += 1
            
            # Fill the right column (top to bottom)
            for row in range(top_row, bottom_row + 1):
                if not head:
                    return matrix
                matrix[row][right_column] = head.val
                head = head.next
            right_column -= 1
            
            # Fill the bottom row (right to left)
            for col in range(right_column, left_column - 1, -1):
                if not head:
                    return matrix
                matrix[bottom_row][col] = head.val
                head = head.next
            bottom_row -= 1
            
            # Fill the left column (bottom to top)
            for row in range(bottom_row, top_row - 1, -1):
                if not head:
                    return matrix
                matrix[row][left_column] = head.val
                head = head.next
            left_column += 1
        
        return matrix