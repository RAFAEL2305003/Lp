"""
# Exercicio 1
count = 0
for i in range(1, 18):
    if i % 3 == 0:
        print(i)
        count += 1

print()

# Exercicio 2
print('for:')
for i in range(1, 101):
    print(i)

print()

i = 1
print('while:')
while i < 101:
    print(i)
    i += 1

print()

# Exercicio 3
i = 10
print('Contagem regressiva:')
while i >= 0:
    print(i)
    i -= 1
print('FIM')

print()

# Exercicio 4
for i in range(0, 100001, 1000):
    print(i)

print()

# Exercicio 5
result = 0
for i in range(10):
    num = int(input('Type one number: '))
    result += num
print(f'\nThe value this sum is {result}')

print()

# Exercicio 6
result = 0
for i in range(10):
    num = int(input('Type one number: '))
    result += num
print(f'\nThe average of that numbers is {result/10}')

print()

# Exercicio 7
i = 0
result = 0
while True:
    if i == 10:
        break
    x = int(input('Type one number: '))
    if x > 0:
        result += x
        i += 1
print(f'\nThe average of that numbers is {result/10}')

print()

# Exercicio 8
i = 0
maxN = -1000000
minN = 1000000

for i in range(10):
    number = int(input('Type one number: '))
    if maxN < number:
        maxN = number
    if minN > number:
        minN = number
print(f'The maximum value is {maxN} and the maximum number is {minN}')

# Exercicio 9
n = int(input('Type the amount of numbers: '))

if n > 0:
    print()
    for i in range(n + 1):
        if i % 2 != 0:
            print(f'The number {i} is odd!')
else:
    print('This number is negative, please type one number positive!')

print()

# Exercicio 10
result = 0
for i in range(51):
    if i % 2 == 0:
        result += i
print(f'The result of the sum of the 50 first numbers positives is {result}')

print()

# Exercicio 11
m = 1
num = 1
n = int(input('Type one number bigger what 0: '))
for i in range(n):
    for j in range(m):
        print(num, ' ', end="")
        num += 1
    print()
    m += 1

# Exercicio 12
print()

S = 0
j = 0
for i in range(1, 100, 2):
    j += 1
    S += i / j
print(f'The value of S is {S}')

print()

# Exercicio 13
res1 = 0
res2 = 0
for i in range(1, 101):
    res1 += i ** 2
for i in range(1, 101):
    res2 += i
print(f'This result find is {res1} and {res2 ** 2}')

print()

# Exercicio 14
add = 0
n = 0
while True:
    age = int(input('Type your age: '))
    if age == 0:
        break
    elif age > 0:
        add += age
        n += 1
average = add / n
print(f'The average of ages is {average}')

print()

# Exercicio 15
n = int(input('Type one number: '))
for i in range(n + 1):
    print(f'The number is {i}')

print()

# Exercicio 16
n = int(input('Type one number: '))
for i in range(n, 0, -1):
    print(f'The number is {i}')
"""

