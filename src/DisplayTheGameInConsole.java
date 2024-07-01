import java.util.Set;

public class DisplayTheGameInConsole implements DisplayTheGame{

    @Override
    public void showWelcome() {
        System.out.println("Добро пожаловать в игру!");
    }

    @Override
    public void showGallows(int errorCount) {
        switch (errorCount) {
            case 0 -> System.out.println(RenderGallows.empty);
            case 1 -> System.out.println(RenderGallows.stageOne);
            case 2 -> System.out.println(RenderGallows.stageTwo);
            case 3 -> System.out.println(RenderGallows.stageThree);
            case 4 -> System.out.println(RenderGallows.stageFour);
            case 5 -> System.out.println(RenderGallows.stageFive);
            case 6 -> {
                System.out.println(RenderGallows.hangedMan);
                System.out.println("Поражение!");
            }
            default -> {
                System.out.println(RenderGallows.amnestyMan);
                System.out.println("Победа!");
            }
        }
    }

    @Override
    public void refreshDisplay() {
        for (int i = 0; i < 20; ++i) System.out.println();
    }

    @Override
    public void showWordMask(Word hiddenWord, Set<Character> correctLettersSet) {
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
    public void showErrorCount(int errorCount, Set<Character> incorrectLettersSet) {
        System.out.print("Количество ошибок: " + errorCount + ".   Буквы, отсутствующие в слове:");
        for (char incorrectChar : incorrectLettersSet) {
            if (incorrectChar != 0) System.out.print(" " + incorrectChar);
        }
        System.out.println();
    }

    @Override
    public void suggestionToEnterLetter() {

    }
}
