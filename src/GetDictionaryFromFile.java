import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GetDictionaryFromFile implements GetDictionary {
    @Override
    public List<String> get() {
        List<String> list = new ArrayList<>();
        String pathToWords = new File("").getAbsolutePath();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(pathToWords.concat("/words.txt"))))){
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        }
        catch (Exception exp){
            System.out.println("Не найден файл словаря, поместите его в корень проекта. Подробнее в README.");
            return list;
        }
        return list;
    }
}
