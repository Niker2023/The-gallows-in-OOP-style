import java.util.Set;

public class DisplayTheGameInConsole implements DisplayTheGame{

    private static final String RED_COLOR = "\u001B[31m";
    private static final String RESET_COLOR = "\u001B[0m";

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showWarningMessage(String message) {
        System.out.println(RED_COLOR + message + RESET_COLOR);
    }

    @Override
    public void showGallows(int errorCount) {
        switch (errorCount) {
            case 0 -> System.out.println(RenderGallows.EMPTY);
            case 1 -> System.out.println(RenderGallows.STAGE_ONE);
            case 2 -> System.out.println(RenderGallows.STAGE_TWO);
            case 3 -> System.out.println(RenderGallows.STAGE_THREE);
            case 4 -> System.out.println(RenderGallows.STAGE_FOUR);
            case 5 -> System.out.println(RenderGallows.STAGE_FIVE);
            case 6 -> System.out.println(RenderGallows.HANGED_MAN);
            default -> System.out.println(RenderGallows.AMNESTY_MAN);
        }
    }

    @Override
    public void refreshDisplay() {
        for (int i = 0; i < 20; ++i) System.out.println();
    }

    @Override
    public void showWordMask(HiddenWord hiddenWord, Set<Character> correctLettersSet) {
        char[] charsWord = hiddenWord.getWord().toCharArray();
        System.out.print("Загаданное слово: ");
        for (char currentChar : charsWord) {
            int state = 0;
            for (char correctLetter : correctLettersSet) {
                if (currentChar == correctLetter) {
                    //Если буква угадана выводим её
                    System.out.print(" " + correctLetter);
                    state = 1;
                }
            }
            //Если буква не угадана выводим *
            if (state == 0) System.out.print(" *");
        }
        System.out.println();
    }

    @Override
    public void showErrorCountAndIncorrectLetters(int errorCount, Set<Character> incorrectLettersSet) {
        System.out.print("Количество ошибок: " + errorCount + ".   Буквы, отсутствующие в слове:");
        for (char incorrectChar : incorrectLettersSet) {
            if (incorrectChar != 0) System.out.print(" " + incorrectChar);
        }
        System.out.println();
    }

    @Override
    public void showHiddenWord(HiddenWord hiddenWord) {
        System.out.println("Загаданное слово: " + hiddenWord.getWord());
    }

}
