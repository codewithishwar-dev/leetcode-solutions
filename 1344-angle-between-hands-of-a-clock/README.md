# 1344. Angle Between Hands of a Clock

## Problem
Given two numbers, `hour` and `minutes`, return the smaller angle (in degrees) formed between the hour and the minute hand.

---

## Approach

A clock has:

- Minute hand moves `6°` per minute (`360 / 60`)
- Hour hand moves `30°` per hour (`360 / 12`)
- Hour hand also moves continuously at `0.5°` per minute (`30 / 60`)

### Formula

```text
hourAngle = (hour % 12) * 30 + minutes * 0.5
minuteAngle = minutes * 6

angle = |hourAngle - minuteAngle|

answer = min(angle, 360 - angle)
