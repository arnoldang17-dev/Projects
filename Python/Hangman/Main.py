import random

print("H A N G M A N\n")
code_list = ('python', 'java', 'swift', 'javascript')

code = random.choice(code_list)
# sub_code = code[:3] + code[3:].replace(code[3:], "-" * len(code[3:]))
attempts = 8
code2 = list("-" * len(code))

while attempts:
    print("".join(code2))    
    answer = input("Input a letter: ")
    
    if code.__contains__(answer):
        index = code.find(answer)
        while index != -1:
            code2[index] = answer
            index = code.find(answer, index + 1)
    else:
        print(f"That letter doesn't appear in the word.")
    
    attempts -= 1

    if "".join(code2) == code or attempts == 0:
        print("\nThanks for playing!")
        break
