import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserEntersFromConsole implements UserEnters{

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public char enterChar(Set<Character> incorrectLettersSet, Set<Character> correctLettersSet) {
        char letter = 0;
        boolean status = true;
        Pattern pattern = Pattern.compile(".*\\p{InCyrillic}.*");
        while (status) {
            System.out.print("Введите букву: ");
            String inChar = scanner.nextLine().toUpperCase();
            Matcher matcher = pattern.matcher(inChar);
            if (inChar.length() != 1){
                System.out.println("Введите один символ:");
                continue;
            } else if (!Character.isLetter(inChar.charAt(0))) {
                System.out.println("Введите букву:");
                continue;
            } else if (!matcher.matches()) {
                System.out.println("Введите кириллицу:");
                continue;
            } else if (correctLettersSet.contains(inChar.charAt(0)) | incorrectLettersSet.contains(inChar.charAt(0))) {
                System.out.println("Данная буква уже вводилась, введите другую:");
                continue;
            }
            letter = inChar.charAt(0);
            status = false;
        }
        return letter;
    }

    @Override
    public boolean shallContinue() {
        System.out.println("Введите любой символ для завершения или оставьте пустую строку для нового раунда");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            return true;
        } else {
            System.out.println("До новых встреч!");
            scanner.close();
            return false;
        }
    }
}