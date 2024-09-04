class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for each in s:
            if(each == '(' or each == '{' or each == '['):
                stack.append(each)
                continue
            if(len(stack) == 0): return False
            
            if(each == ')' and stack[-1] != '('):
                return False
            
            if(each == '}' and stack[-1] != '{'):
                return False
                
            if(each == ']' and stack[-1] != '['):
                return False

            stack.pop()
        return len(stack) == 0