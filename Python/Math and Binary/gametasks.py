import os


def printInstructions(instruction):
    print(instruction)


def getUserScore(userName):
    f = open('userScores.txt', 'w')
    for line in f:
        content = line.split(',')
        if content[0] == userName:
            f.close()
            return int(content[1])

    f.close()
    return '-1'


def updateUserScore(newUser, userName, score):
    if newUser:
        f = open('userScores.txt', 'a')
        f.write(userName + ', ' + str(score) + '\n')
        f.close()

    else:
        f = open('userScores.tmp', 'w')
        h = open('userScores.txt', 'r')

        for line in h:
            content = line.split(',')
            if content[0] == userName:
                f.write(content[0] + ', ' + str(score) + '\n')
            else:
                f.write(line)

        f.close()
        h.close()

        os.remove('userScores.txt')
        os.rename('userScores.tmp', 'userScores.txt')
