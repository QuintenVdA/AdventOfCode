from itertools import combinations
from math import prod

# Read input
input = open("input", "r")

values = []

for line in input:
	values.append(int(line))

input.close()

# Solve
for value in combinations(values, 2):
    if sum(value) == 2020:
        print('Part 1: ' + str(prod(value)))
        
for value in combinations(values, 3):
    if sum(value) == 2020:
        print('Part 2: ' + str(prod(value)))
