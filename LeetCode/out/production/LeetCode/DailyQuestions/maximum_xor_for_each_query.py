class Solution:
    def getMaximumXor(self, nums: List[int], maximumBit: int) -> List[int]:
        answer = []
        xorValue = self.get_target(maximumBit) ^ nums[0]
        n = len(nums)

        for i in range(1, n):
            answer.insert(0, xorValue)
            xorValue ^= nums[i]

        answer.insert(0, xorValue)
        return answer

    def get_target(selfself, maximum_bit: int ):
        return pow(2, maximum_bit)