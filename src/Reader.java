import java.util.Set;

public interface Reader {

    char enterChar(Set<Character> correctLettersSet, Set<Character> incorrectLettersSet, Printer display);

    boolean shallContinue(Printer display);

}
