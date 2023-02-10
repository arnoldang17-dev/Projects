import random

print("H A N G M A N")
code_list = ('python', 'java', 'swift', 'javascript')

code = random.choice(code_list)

answer = input("Guess the word: ")

if code == answer:
    print("You survived!")
else:
    print("You lost!")
