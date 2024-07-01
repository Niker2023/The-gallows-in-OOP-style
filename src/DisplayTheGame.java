import java.util.Set;

public interface DisplayTheGame {

    void showWelcome();

    void showGallows(int errorCount);

    void refreshDisplay();

    void showWordMask(Word hiddenWord, Set<Character> correctLettersSet);

    void showErrorCount(int errorCount, Set<Character> incorrectLettersSet);

    void suggestionToEnterLetter();
}
