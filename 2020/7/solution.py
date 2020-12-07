import re

def containsShinyGoldBag(rules, rule):
    if 'shiny gold' in str(rule):
        return 1
    for bag in rule:
        if containsShinyGoldBag(rules, rules[re.findall(' (\D+ \D+)', bag)[0]]):
            return 1
    return 0

def countBags(rules, rule):
    count = 1
    for bag in rule:
        count += int(re.findall('(\d+)', bag)[0]) * countBags(rules, rules[re.findall(' (\D+ \D+)', bag)[0]])
    return count

result1, rules = 0, {}

for line in open('input', 'r').read().splitlines():
    rules[re.findall('(\w+ \w+)', line)[0]] = re.findall('(\d+ \w+ \w+)+', line)

for name, rule in rules.items():
    result1 += containsShinyGoldBag(rules, rule)

print('Part 1:', result1)
print('Part 2:', countBags(rules, rules['shiny gold']) - 1)
