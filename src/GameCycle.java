import java.util.HashSet;
import java.util.Set;

public class GameCycle {

    public static void startGame() {

        boolean gameIsOn = true;
        int errorCount = -1;
        Set<Character> correctLettersSet = new HashSet<>();
        Set<Character> incorrectLettersSet = new HashSet<>();

        WorkingWithTheDictionary dictionary = new DictionaryFromFile().initializeTheDictionary();
        DisplayTheGame displayTheGame = new DisplayTheGameInConsole();

        while (gameIsOn) {

            if (errorCount == -1) {
                Word currentWord = new Word(dictionary.getRandomWord());
                if (currentWord.getWord().isEmpty()) {
                    break;
                }
                displayTheGame.showWelcome();
                System.out.println("Добро пожаловать в игру!");
                errorCount++;
            } else {

            }

        }
    }
}
