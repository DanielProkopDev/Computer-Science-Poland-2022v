import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.*;


public class Liczby implements Serializable {





    public Set<Integer> getLiczby(){
        Set<Integer> liczbySet = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("./Dane_2205/przyklad.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                liczbySet.add(Integer.parseInt(line.trim()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return liczbySet;

    }


    public  List<Integer> getLiczby1(){
        List<Integer> liczby = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("./Dane_2205/przyklad.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                liczby.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(liczby);
        return liczby;
    }

    public void writeLiczby(List<String> dobreTrojkiPiatki){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./Dane_2205/wyniki.txt"))) {
            for (String trojka : dobreTrojkiPiatki) {
                writer.write(trojka + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  boolean isDobraTrojka(int a, int b, int c) {
        return b % a == 0 && c % b == 0 && a != b && b != c;
    }

    public  boolean isDobraPiatka(int a, int b, int c, int d, int e) {
        return b % a == 0 && c % b == 0 && d % c == 0 && e % d == 0 &&
                a != b && b != c && c != d && d != e;
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

    public  List<List<Integer>> getDobrePiatki(Set<Integer> liczbySet) {
        List<Integer> liczby = new ArrayList<>(liczbySet);
        Collections.sort(liczby);
        List<List<Integer>> dobrePiatki = new ArrayList<>();
        int n = liczby.size();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        for (int m = l + 1; m < n; m++) {
                            if (isDobraPiatka(liczby.get(i), liczby.get(j), liczby.get(k), liczby.get(l), liczby.get(m))) {
                                List<Integer> piatka = new ArrayList<>();
                                piatka.add(liczby.get(i));
                                piatka.add(liczby.get(j));
                                piatka.add(liczby.get(k));
                                piatka.add(liczby.get(l));
                                piatka.add(liczby.get(m));
                                dobrePiatki.add(piatka);
                            }
                        }
                    }
                }
            }
        }

        return dobrePiatki;
    }
    public  List<List<Integer>> getDobreTrojki(Set<Integer> liczbySet) {
        List<Integer> liczby = new ArrayList<>(liczbySet);
        Collections.sort(liczby);
        List<List<Integer>> dobreTrojki = new ArrayList<>();
        int n = liczby.size();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (isDobraTrojka(liczby.get(i), liczby.get(j), liczby.get(k))) {
                        List<Integer> trojka = new ArrayList<>();
                        trojka.add(liczby.get(i));
                        trojka.add(liczby.get(j));
                        trojka.add(liczby.get(k));
                        dobreTrojki.add(trojka);
                    }
                }
            }
        }

        return dobreTrojki;
    }


    //RECURSIVE APPROACH

    public  boolean isDobraTrojka1(List<Integer> numbers) {
        return numbers.get(1) % numbers.get(0) == 0 && numbers.get(2) % numbers.get(1) == 0 &&
                !numbers.get(0).equals(numbers.get(1)) && !numbers.get(1).equals(numbers.get(2));
    }

    public boolean isDobraPiatka1(List<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) % numbers.get(i - 1) != 0) {
                return false;
            }
        }

        return new HashSet<>(numbers).size() == numbers.size();
    }

    public  void findDobreTrojki(List<Integer> numbers, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == 3) {
            if (isDobraTrojka1(current)) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        for (int i = 0; i < numbers.size(); i++) {
            current.add(numbers.get(i));
            findDobreTrojki(numbers, current, result);
            current.remove(current.size() - 1);
        }
    }



    public void findDobrePiatki(List<Integer> numbers, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == 5) {
            if (isDobraPiatka1(current)) {
                System.out.println(current);
                result.add(new ArrayList<>(current));
            }
            return;
        }

        if (!current.isEmpty()) {
            int lastNumber = current.get(current.size() - 1);
            for (int i = 0; i < numbers.size(); i++) {
                int number = numbers.get(i);
                if (number % lastNumber == 0) {
                    current.add(number);
                    findDobrePiatki(numbers, current, result);
                    current.remove(current.size() - 1);
                }
            }
        } else {
            for (int i = 0; i < numbers.size(); i++) {
                int number = numbers.get(i);
                current.add(number);
                findDobrePiatki(numbers, current, result);
                current.remove(current.size() - 1);
            }
        }
    }



}

