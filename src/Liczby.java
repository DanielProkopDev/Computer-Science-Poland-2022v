import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Liczby implements Serializable {

String fileName;

public void setFileName(String fileName){
    this.fileName=fileName;
    System.out.println(this.fileName);
}
    static Path path1 = Paths.get("./Dane_2205/przyklad.txt");

    public String getFileName() {
        return fileName;
    }

    public static Path getPath1() {
        return path1;
    }

    public static String getNumbersOneandLast(Path path){
        try{
            int count=0;
            final List<String> numbers= Files.readAllLines(path);
            System.out.println(numbers);
            for (int i=0; i < numbers.size();i++){

                String numberOne= numbers.get(i).substring(0,1);
                //System.out.println(numberOne);
                if (numbers.get(i).endsWith(numberOne)){
                    ++count;
                }

            }
            System.out.println(count);
            return String.valueOf(count);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String czynnikPierwszy(Path path) throws IOException {
        final List<String> numbers= Files.readAllLines(path);

        List<List<String>> numbers1= new ArrayList<>();
        System.out.println(numbers);
        for (int i=0; i < numbers.size();i++){
            int k = 2;
            int n = Integer.parseInt(numbers.get(i));
            List<String> number= new ArrayList<>();
            number.add(numbers.get(i));
            System.out.print("\n"+ n+" ");
               while (k <= n) {
                   while ((n % k) == 0) {

                       n /= k;
                       number.add(String.valueOf(k));
                       System.out.print(k+" ");

                   }
                   ++k;
               }
               if (numbers1.size() == 0){
                   numbers1.add(number);
               }
               else if (number.size() > numbers1.get(0).size()){
                   numbers1.remove(0);
                   numbers1.add(number);
               }

            System.out.println(numbers1);
        }
        String odpowiedz="Najwiecej czynnikow pierwszych ma cyfra: "+numbers1.get(0).get(0) +" Liczba czynnikow pierwszych to: "+numbers1.get(0).subList(1, numbers1.get(0).size()).size() + " jej czynniki pierwsze to: "+numbers1.get(0).subList(1, numbers1.get(0).size());
        return odpowiedz;
    }

    public static String czynnikPierwszyRozny(Path path) throws IOException {
        final List<String> numbers = Files.readAllLines(path);

        List<List<String>> numbers1 = new ArrayList<>();
        System.out.println(numbers);
        for (int i = 0; i < numbers.size(); i++) {
            int k = 2;
            int n = Integer.parseInt(numbers.get(i));
            List<String> number = new ArrayList<>();
            number.add(numbers.get(i));
            System.out.print("\n" + n + " ");
            while (k <= n) {
                while ((n % k) == 0) {

                    n /= k;
                    if (number.size() == 1) {
                        number.add(String.valueOf(k));
                    } else if (Integer.parseInt(number.get(number.size()-1)) != k) {
                        number.add(String.valueOf(k));
                    }

                    System.out.print(k + " ");

                }
                ++k;
            }
            if (numbers1.size() == 0) {
                numbers1.add(number);
            } else if (number.size() > numbers1.get(0).size()) {
                numbers1.remove(0);
                numbers1.add(number);
            }

            System.out.println(numbers1);
        }
        String odpowiedz1 = "Najwiecej roznych czynnikow pierwszych ma cyfra: " + numbers1.get(0).get(0) + " Liczba roznych czynnikow pierwszych to: " + numbers1.get(0).subList(1, numbers1.get(0).size()).size() + " jej czynniki pierwsze to: " + numbers1.get(0).subList(1, numbers1.get(0).size());
        return odpowiedz1;
    }

    public static void dobraPiatka(Path path) throws IOException {
        final List<String> numbers = Files.readAllLines(path);
        System.out.println(numbers);

        List<List<String>> numberZ= new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            List<String> number = new ArrayList<>();
            List<String> numberX = new ArrayList<>();
            int k = 2;
            int n = Integer.parseInt(numbers.get(i));
            number.add(String.valueOf(n));
            System.out.print("\n" + n + " ");
            while (k <= n) {
                while ((n % k) == 0) {

                    n /= k;
                    if (n > 1) {
                        System.out.print(n + " ");
                        number.add(String.valueOf(n));
                    }
                }
                ++k;

            }
            System.out.println(number);
            if (number.size() > 5){
                numberX.addAll(number);
                System.out.println(numberX);
                if (Integer.parseInt(numberX.get(numberX.size()-2))%Integer.parseInt(numberX.get(numberX.size()-1))==0){
                numberZ.add(numberX);}
                numberX.clear();
            }
        }
        System.out.println("Liczba dobrych piatek to: "+ numberZ.size());


    }
    public static void dobraTrojka(Path path) throws IOException {
        final List<String> numbers = Files.readAllLines(path);
        List<List<String>> numberZ = new ArrayList<>();
        System.out.println(numbers);

        int x = 0;
        int y = 0;
        int z = 0;
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            List<String> number = new ArrayList<>();
            List<String> numberX = new ArrayList<>();


            int k = 2;
            int n = Integer.parseInt(numbers.get(i));


            System.out.print("\n" + n + " ");
            while (k <= n) {
                while ((n % k) == 0) {

                    n /= k;
                    if (n > 1) {
                        System.out.print(n + " ");
                        number.add(String.valueOf(n));
                    }
                }
                ++k;

            }
            System.out.println(number);
            if (number.size() == 2){
                count = count +1;
            }
            if (number.size() == 3){
                count = count +3;
            }
            if (number.size() == 4){
                count = count +6;
            }
            if (number.size() == 5){
                count = count +10;
            }
            if (number.size() == 6){
                count = count +12;
            }

        }
        System.out.println("Liczba dobrych trojke to "+count);




    }
    /** nie udana proba, ktorej lepiej unikac
     * z = Integer.parseInt(number.get(0));
     *      while (number.size() >0) {
     *      if (numberX.size() == 3){
     *      System.out.println(numberX);
     *      numberZ.add(numberX);
     *      numberX.clear();
     *      }
     *      System.out.println(number);
     *      System.out.println("z =" + z);
     *      number.remove(String.valueOf(z));
     *      if (number.size() != 0) {
     *      x = Integer.parseInt(number.get(0));
     *      numberX.add(String.valueOf(x));
     *      number.remove(String.valueOf(x));
     *      y = Integer.parseInt(number.get(0));
     *      numberX.add(String.valueOf(y));
     *      number.remove(String.valueOf(y));
     *
     *
     *      if (Integer.parseInt(numberX.get(0)) != x) {
     *      numberX.add(String.valueOf(x));
     *      }
     *      if (Integer.parseInt(numberX.get(1)) != y) {
     *      numberX.add(String.valueOf(y));
     *      }
     *      if (Integer.parseInt(numberX.get(numberX.size() - 1)) != z) {
     *      numberX.add(String.valueOf(z));
     *      }
     *      }
     *      }
     */


}
