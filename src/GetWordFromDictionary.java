import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GetWordFromDictionary implements GetWord {
    @Override
    public String get() {
        GetDictionary dictionary = new GetDictionaryFromFile();
        List<String> list = dictionary.get();
        Random random = new Random();
        return list.get(random.nextInt(list.size())).toUpperCase();
    }
}
