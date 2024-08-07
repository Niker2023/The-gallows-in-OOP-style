import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class DictionaryLoaderFromFile implements DictionaryLoader {

    private List<String> dictionary;

    @Override
    public DictionaryLoader initializeTheDictionary(Printer display) {
        dictionary = new ArrayList<>();
        String pathToWords = new File("").getAbsolutePath();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(pathToWords.concat("/words.txt"))))){
            String line;
            while ((line = br.readLine()) != null) {
                dictionary.add(line);
            }
        }
        catch (Exception exp){
            display.showWarningMessage("Не найден файл словаря, поместите его в корень проекта. Подробнее в README.");
        }
        return this;
    }

    @Override
    public String getRandomWord() {
        if (dictionary.size() == 0) {
            return "";
        } else {
            Random random = new Random();
            return dictionary.get(random.nextInt(dictionary.size())).toUpperCase();
        }
    }
}
