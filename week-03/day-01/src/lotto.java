import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hegyi on 2017-03-27.
 */
public class lotto {

  public static void main(String[] args) {
    Path paths = Paths.get("assets/otos.csv");
    HashMap<Integer, Integer> lottoNumbers = new HashMap<>();


    try {
      List<String> lines = Files.readAllLines(paths);


      for (String text : lines) {
        int lastPart = text.lastIndexOf("Ft");
        String lastFive = text.substring(lastPart + 3);
        List<String> numbers = Arrays.asList(lastFive.split(";"));

        for ( String text2 : numbers) {
          int value = Integer.parseInt(text2);
          if (lottoNumbers.containsKey(value)) {
            lottoNumbers.put(value, lottoNumbers.get(value) + 1);
          } else {
            lottoNumbers.put(value, 1);
          }
        }


      }
      System.out.println(lottoNumbers);



    } catch (Exception e) {
      System.out.println(e.getCause());
    }


  }
}



// Create a method that find the 5 most common lotto number assets/lotto.csv