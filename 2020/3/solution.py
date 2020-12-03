def checkSlopes(terrain, right, down):
    trees = 0
    x = 0
    y = 0

    for line in terrain:
        if y % down == 0:
            if line[x] == '#':
                trees += 1

            x += right

            if x >= len(line) - 1:
                x -= len(line) - 1

        y += 1

    return trees

def checkMultipleSlopes(terrain, slopes):
    result = 1
    for slope in slopes:
        result *= checkSlopes(terrain, slope[0], slope[1])
    return result

# Read input
terrain = []
input = open("input", "r")
for line in input:
    terrain.append(line)
input.close()


# Solve
print('Part 1: ' + str(checkSlopes(terrain, 3, 1)))
print('Part 2: ' + str(checkMultipleSlopes(terrain, [[1, 1], [3, 1], [5, 1], [7, 1], [1, 2]])))
