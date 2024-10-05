class Solution:
    def dividePlayers(self, skill: List[int]) -> int:
        skill.sort()
        value = skill[0] + skill[-1]
        answer = 0
        while len(skill) != 0 :
            a = skill.pop(0)
            b = skill.pop()
            if a + b != value :
                return -1
            answer += a * b
        return answer
