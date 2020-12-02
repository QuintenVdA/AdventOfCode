import re

input = open("input", "r")

result1 = 0
result2 = 0

for line in input:
    policy1, policy2, letter, password = re.split('-| |: ', line)

    # Part 1
    min = int(policy1)
    max = int(policy2)

    if int(min) <= password.count(letter) <= int(max):
        result1 = result1 + 1

    # Part 2
    index1 = int(policy1) - 1
    index2 = int(policy2) - 1

    if (password.find(letter, index1) == index1) ^ (password.find(letter, index2) == index2):
        result2 = result2 + 1

print('Part 1: ' + str(result1))
print('Part 2: ' + str(result2))

input.close()
