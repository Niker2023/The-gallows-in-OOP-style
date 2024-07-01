import java.util.Set;

public interface UserEnters {

    char enterChar(Set<Character> correctLettersSet, Set<Character> incorrectLettersSet);

    boolean shallContinue();

}
