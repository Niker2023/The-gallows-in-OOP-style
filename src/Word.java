import java.util.Set;

public class Word {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public boolean isGuessed(Set<Character> correctLettersSet) {
        int i = 0;
        for (Character w : word.toCharArray()) {
            int j = 0;
            for (Character c : correctLettersSet) {
                // Проверяем есть ли для каждой буквы слова аналогичная среди правильных букв
                if (w.equals(c)) {
                    j++;
                }
            }
            // Если букве не нашлась пара увеличиваем i
            if (j == 0) i++;
        }
        // Возвращаем истину если есть соответствие каждой букве
        return i == 0;
    }
}
