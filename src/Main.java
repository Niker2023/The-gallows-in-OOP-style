// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Word word = new Word();
        GetWord getWord = new GetWordFromDictionary();
        word.setWord(getWord.get());
        System.out.println(word.getWord());
    }
}