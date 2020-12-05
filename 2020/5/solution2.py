import re

result1, result2, allSeats = 0, 0, []

input = open('input', 'r')

for line in input:
    seat = int(re.sub('(B|R)', '1', re.sub('(F|L)', '0', line)), 2)

    allSeats.append(seat)

    if seat > result1:
        result1 = seat

input.close()

result2 = result1

while result2 in allSeats:
    result2 -= 1

print('Part 1: ' + str(result1))
print('Part 2: ' + str(result2))

