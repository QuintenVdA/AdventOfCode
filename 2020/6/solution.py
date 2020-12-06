result1, result2 = 0, 0

for group in open('input', 'r').read().split('\n\n'):
    result1 += len(set(group.replace('\n', '')))
    result2 += len(set(group.split('\n')[0]).intersection(*group.split('\n')))

print('Part 1: ' + str(result1))
print('Part 2: ' + str(result2))
