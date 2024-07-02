import java.util.Set;

public interface DisplayTheGame {

    void showMessage(String message);

    void showWarningMessage(String message);

    void showGallows(int errorCount);

    void refreshDisplay();

    void showWordMask(Word hiddenWord, Set<Character> correctLettersSet);

    void showErrorCountAndIncorrectLetters(int errorCount, Set<Character> incorrectLettersSet);

    void showHiddenWord(Word word);

}
