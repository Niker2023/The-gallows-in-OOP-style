import java.util.Set;

public interface Printer {

    void showMessage(String message);

    void showWarningMessage(String message);

    void showGallows(int errorCount);

    void refreshDisplay();

    void showWordMask(HiddenWord hiddenWord, Set<Character> correctLettersSet);

    void showErrorCountAndIncorrectLetters(int errorCount, Set<Character> incorrectLettersSet);

    void showHiddenWord(HiddenWord hiddenWord);

}
