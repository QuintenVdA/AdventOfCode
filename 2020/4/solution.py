import re

input = open("input", "r")

currentPassport = {}
passports = []


# Read
for line in input:
    if len(line) > 1:
        for pair in line.rstrip('\n').split(' '):
            currentPassport[pair.split(':')[0]] = pair.split(':')[1]
    else:
        passports.append(currentPassport)
        currentPassport = {}

passports.append(currentPassport)

input.close()


# Solve
result1 = 0
result2 = 0

for passport in passports:
    if all(x in passport.keys() for x in ['byr', 'iyr', 'eyr', 'hgt', 'hcl', 'ecl', 'pid']):
        result1 += 1

        if (1920 <= int(passport['byr']) <= 2002
            and 2010 <= int(passport['iyr']) <= 2020
            and 2020 <= int(passport['eyr']) <= 2030
            and re.match('^\d+(cm|in)$', passport['hgt'])
            and ((passport['hgt'][-2:] == 'cm' and 150 <= int(re.findall('(\d+)', passport['hgt'])[0]) <= 193)
                or (passport['hgt'][-2:] == 'in' and 59 <= int(re.findall('(\d+)', passport['hgt'])[0]) <= 76))
            and re.match('^#[0-9a-f]{6}$', passport['hcl'])
            and passport['ecl'] in ['amb', 'blu', 'brn', 'gry', 'grn', 'hzl', 'oth']
            and re.match('^\d{9}$', passport['pid'])):
            result2 += 1

print('Part 1: ' + str(result1))
print('Part 2: ' + str(result2))   
