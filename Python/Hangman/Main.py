import random

print("H A N G M A N")
code_list = ('python', 'java', 'swift', 'javascript')

code = random.choice(code_list)
# sub_code = code[:3] + code[3:].replace(code[3:], "-" * len(code[3:]))
attempts = 8
code2 = list("-" * len(code))
all_answer = []
while attempts:
    print()
    try:
        print("".join(code2))    
        answer = input("Input a letter: ")
        if len(answer) > 1: raise Exception
        
        if code.__contains__(answer) and answer not in all_answer:
            all_answer.append(answer)
            index = code.find(answer)
            while index != -1:
                code2[index] = answer
                index = code.find(answer, index + 1)
        elif answer in all_answer:
            print("No improvements.")
            attempts -= 1
            
        else:
            attempts -= 1
            print("That letter doesn't appear in the word.")
                 
    except Exception:
        continue;
        
    if "".join(code2) == code:
        print("".join(code2))
        print("You guessed the word!")
        print("You survived!")
        break
    elif attempts == 0:
        print("You lost!")
