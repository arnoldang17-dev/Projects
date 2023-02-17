import random

print("H A N G M A N")
code_list = ('python', 'java', 'swift', 'javascript')

code = random.choice(code_list)
sub_code = code[:3] + code[3:].replace(code[3:], "-" * len(code[3:]))
print(code)      
answer = input("Guess the word: " + sub_code + ":  ")

if code == answer:
    print("You survived!")
else:
    print("You lost!")
