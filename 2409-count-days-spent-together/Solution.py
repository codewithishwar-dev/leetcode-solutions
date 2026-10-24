
class Solution:
    def countDaysTogether(
        self,
        arriveAlice: str,
        leaveAlice: str,
        arriveBob: str,
        leaveBob: str
    ) -> int:
        days_in_month = [
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        ]

        def convert_to_day(date: str) -> int:
            month = int(date[:2])
            day = int(date[3:])

            day += sum(days_in_month[:month - 1])
            return day

        alice_start = convert_to_day(arriveAlice)
        alice_end = convert_to_day(leaveAlice)
        bob_start = convert_to_day(arriveBob)
        bob_end = convert_to_day(leaveBob)

        start = max(alice_start, bob_start)
        end = min(alice_end, bob_end)

        return max(0, end - start + 1)
