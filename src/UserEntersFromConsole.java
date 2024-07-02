import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserEntersFromConsole implements UserEnters{

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public char enterChar(Set<Character> incorrectLettersSet, Set<Character> correctLettersSet, DisplayTheGame display) {
        char enteredLetter = 0;
        boolean isInputCorrectLetter = false;
        boolean isCorrectLatter = true;
        Pattern pattern = Pattern.compile(".*\\p{InCyrillic}.*");
        while (!isInputCorrectLetter) {
            if (isCorrectLatter) {
                display.showMessage("Введите букву: ");
            }
            isCorrectLatter = true;
            String inChar = scanner.nextLine().toUpperCase();
            Matcher matcher = pattern.matcher(inChar);
            if (inChar.length() != 1){
                display.showWarningMessage("Введите один символ:");
                isCorrectLatter = false;
                continue;
            } else if (!Character.isLetter(inChar.charAt(0))) {
                display.showWarningMessage("Введите букву:");
                isCorrectLatter = false;
                continue;
            } else if (!matcher.matches()) {
                display.showWarningMessage("Введите кириллицу:");
                isCorrectLatter = false;
                continue;
            } else if (correctLettersSet.contains(inChar.charAt(0)) | incorrectLettersSet.contains(inChar.charAt(0))) {
                display.showWarningMessage("Данная буква уже вводилась, введите другую:");
                isCorrectLatter = false;
                continue;
            }
            enteredLetter = inChar.charAt(0);
            isInputCorrectLetter = true;
        }
        return enteredLetter;
    }

    @Override
    public boolean shallContinue(DisplayTheGame display) {
        display.showMessage("Введите любой символ для завершения или оставьте пустую строку для нового раунда");
        String enteredText = scanner.nextLine();
        if (enteredText.isEmpty()) {
            return true;
        } else {
            display.showMessage("До новых встреч!");
            scanner.close();
            return false;
        }
    }
}