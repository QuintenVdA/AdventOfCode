import math

def search(info, min, max):
    if len(info) == 0:
        return min
    elif info[0] in ['F', 'L']:
        return search(info[1:], min, math.floor((min+max)/2))
    else:
        return search(info[1:], math.ceil((min+max)/2), max)

result1 = 0
result2 = 0
allSeats = []

input = open('input', 'r')

for line in input:
    row = search(line[:7], 0, 127)
    col = search(line[7:10], 0, 7)
    seat = row * 8 + col

    allSeats.append(seat)

    if seat > result1:
        result1 = seat
    
input.close()

for i in range(result1, 0, -1):
    if i not in allSeats:
        result2 = i
        break

print('Part 1: ' + str(result1))
print('Part 2: ' + str(result2))
