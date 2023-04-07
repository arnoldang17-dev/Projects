import random

print("H A N G M A N")
code_list = ('python', 'java', 'swift', 'javascript')
win = 0
loss = 0

while True:
    player_input = input("Type \"play\" to play the game, \"results\" to show the scoreboard, and \"exit\" to quit: ")
    if player_input == "play":
        code = random.choice(code_list)
        attempts = 8
        code2 = list("-" * len(code))
        all_answer = []
        while attempts:
            print()
            try:
                print("".join(code2))    
                answer = input("Input a letter: ")
                if len(answer) > 1 or answer == "": 
                    raise Exception
                elif answer.isupper() or not answer.isalpha():
                    print("Please, enter a lowercase letter from the English alphabet.")
                    continue
                    
                if code.__contains__(answer) and answer not in all_answer:
                    all_answer.append(answer)
                    index = code.find(answer)
                    while index != -1:
                        code2[index] = answer
                        index = code.find(answer, index + 1)
                        
                elif answer in all_answer:
                    print("You've already guessed this letter.")
                    
                else:
                    attempts -= 1
                    all_answer.append(answer)
                    print("That letter doesn't appear in the word.")
                        
            except Exception:
                print("Please, input a single letter.")
                continue
                
            if "".join(code2) == code:
                print(f"You guessed the word {code}!")
                print("You survived!")
                win += 1
                break
            
            elif attempts == 0:
                print("\nYou lost!")
                loss += 1
        
        continue
    elif player_input == "results":
        print(f"You won: {win} times.")
        print(f"You lost: {loss} times.")
        continue
    elif player_input == "exit":
        break
        
