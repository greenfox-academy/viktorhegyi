/**
 * Created by hegyi on 2017-03-23.
 */
public class todoprint {
  public static void main(String... args){
    String todoText = " - Buy milk\n";

    todoText = "My todo:\n" + todoText + " - Download games\n" + "\t - Diablo";
    // Add "My todo:" to the beginning of the todoText
    // Add " - Download games" to the end of the todoText
    // Add " - Diablo" to the end of the todoText but with indention

    // Expected outpt:

    // My todo:
    //  - Buy milk
    //  - Download games
    //      - Diablo

    System.out.println(todoText);
  }

}
