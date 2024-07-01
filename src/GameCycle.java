import java.util.HashSet;
import java.util.Set;

public class GameCycle {

    public static void startGame() {

        boolean gameIsOn = true;
        int errorCount = -1;
        Set<Character> correctLettersSet = new HashSet<>();
        Set<Character> incorrectLettersSet = new HashSet<>();
        char enteredLetter;

        WorkingWithTheDictionary dictionary = new DictionaryFromFile().initializeTheDictionary();
        DisplayTheGame display = new DisplayTheGameInConsole();
        UserEnters enters = new UserEntersFromConsole();
        Word hiddenWord = new Word("");

        while (gameIsOn) {

            if (errorCount == -1) {
                hiddenWord = new Word(dictionary.getRandomWord());
                if (hiddenWord.getWord().isEmpty()) {
                    break;
                }
                display.showWelcome();
                errorCount++;
            } else {
                display.refreshDisplay();
            }
            display.showGallows(errorCount);
            display.showWordMask(hiddenWord, correctLettersSet);
            display.showErrorCount(errorCount, incorrectLettersSet);
            enteredLetter = enters.enterChar(correctLettersSet, incorrectLettersSet);
            if (hiddenWord.getWord().indexOf(enteredLetter) == -1) {
                incorrectLettersSet.add(enteredLetter);
                errorCount++;
            } else {
                correctLettersSet.add(enteredLetter);
            }
            if (errorCount == 6 || hiddenWord.isGuessed(correctLettersSet)) {
                display.refreshDisplay();

                if (errorCount == 6) {
                    display.showGallows(errorCount);
                    display.showLose();
                } else {
                    display.showGallows(777);
                    display.showVictory();
                }
                display.showHiddenWord(hiddenWord);
                // Предложение сыграть снова
                if (enters.shallContinue()) {
                    errorCount = -1;
                    correctLettersSet.clear();
                    incorrectLettersSet.clear();
                    display.refreshDisplay();
                } else {
                    gameIsOn = false;
                }
            }
        }
    }
}
