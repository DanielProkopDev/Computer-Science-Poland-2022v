import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

Liczby liczbyObject = new Liczby();
/**     LOOPY APPROACH--->
 *
        List<List<Integer>> dobreTrojki = liczbyObject.getDobreTrojki(liczbyObject.getLiczby());
        List<List<Integer>> dobrePiatki = liczbyObject.getDobrePiatki(liczbyObject.getLiczby());

        int iloscDobrychTrojek = dobreTrojki.size();
        int iloscDobrychPiatek = dobrePiatki.size();

        System.out.println("a) Podaj, ile jest dobrych trójek wśród liczb występujących w pliku liczby.txt: " +
                iloscDobrychTrojek);
        System.out.println("b) Podaj, ile jest dobrych piątek wśród liczb występujących w pliku liczby.txt: " +
                iloscDobrychPiatek);
 */
/**    Recursive --->*/

        List<List<Integer>> dobreTrojki1 = new ArrayList<>();
       List<List<Integer>> dobrePiatki1 = new ArrayList<>();

        liczbyObject.findDobreTrojki(liczbyObject.getLiczby1(), new ArrayList<>(), dobreTrojki1);
        liczbyObject.findDobrePiatki(liczbyObject.getLiczby1(), new ArrayList<>(), dobrePiatki1);

        System.out.println("a) Podaj, ile jest dobrych trójek wśród liczb występujących w pliku liczby.txt: " +
              dobreTrojki1.size());
        System.out.println("b) Podaj, ile jest dobrych piątek wśród liczb występujących w pliku liczby.txt: " +
               dobrePiatki1.size());

    }
}