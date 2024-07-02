import java.util.Set;

public interface UserEnters {

    char enterChar(Set<Character> correctLettersSet, Set<Character> incorrectLettersSet, DisplayTheGame display);

    boolean shallContinue(DisplayTheGame display);

}
