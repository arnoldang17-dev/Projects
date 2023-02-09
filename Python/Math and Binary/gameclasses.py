import randit
class Game:
    
    def __init__(self, noOfQuestions = 0):
        self._noOfQuestions = noOfQuestions

    @property
    def noOfQuestions(self):
        return self._noOfQuestions
    
    def setNoOfQuestions(self, value):
        if value < 1:
            self._noOfQuestions = 1
            print("Minimum Number of Questions = 1")
            print("Hence, number of questions will be set to 1")
        
        elif value > 10:
            self._noOfQuestions = 10
            print("Maximum Number of Questions = 10")
            print("Hence, number of questions will be set to 10")
        
        else:
            self._noOfQuestions = value
            
class BinaryGame(Game):
    
    def generateQuestions(self):
             