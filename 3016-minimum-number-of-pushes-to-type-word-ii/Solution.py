from collections import Counter


class Solution:
    def minimumPushes(self, word: str) -> int:
        # Count frequency of each character
        frequencies = Counter(word)

        # Sort frequencies in descending order
        sorted_freq = sorted(frequencies.values(), reverse=True)

        pushes = 0

        # Assign cheaper positions to more frequent characters
        for i, freq in enumerate(sorted_freq):
            cost = (i // 8) + 1
            pushes += freq * cost

        return pushes
