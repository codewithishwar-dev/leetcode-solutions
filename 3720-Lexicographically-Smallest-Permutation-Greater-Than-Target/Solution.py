class Solution:
    def lexGreaterPermutation(self, s: str, target: str) -> str:
        freq = [0] * 26

        for ch in s:
            freq[ord(ch) - ord('a')] += 1

        n = len(s)

        for i in range(n):
            current = ord(target[i]) - ord('a')

            if freq[current] == 0:
                return self.build_answer(target, i, freq)

            freq[current] -= 1

        # target itself is a permutation of s.
        # Find the next lexicographical permutation.
        for i in range(n - 1, -1, -1):
            current = ord(target[i]) - ord('a')

            freq[current] += 1

            for c in range(current + 1, 26):
                if freq[c] > 0:
                    result = target[:i]
                    result += chr(ord('a') + c)

                    freq[c] -= 1

                    result += self.build_sorted(freq)

                    return result

        return ""

    def build_answer(self, target: str, fail_index: int, freq: list[int]) -> str:
        current = ord(target[fail_index]) - ord('a')

        # Try increasing the current position.
        for c in range(current + 1, 26):
            if freq[c] > 0:
                result = target[:fail_index]
                result += chr(ord('a') + c)

                freq[c] -= 1

                result += self.build_sorted(freq)

                return result

        # Backtrack to find the rightmost position
        # that can be increased.
        for i in range(fail_index - 1, -1, -1):
            current = ord(target[i]) - ord('a')

            freq[current] += 1

            for c in range(current + 1, 26):
                if freq[c] > 0:
                    result = target[:i]
                    result += chr(ord('a') + c)

                    freq[c] -= 1

                    result += self.build_sorted(freq)

                    return result

        return ""

    def build_sorted(self, freq: list[int]) -> str:
        result = []

        for c in range(26):
            while freq[c] > 0:
                result.append(chr(ord('a') + c))
                freq[c] -= 1

        return ''.join(result)
