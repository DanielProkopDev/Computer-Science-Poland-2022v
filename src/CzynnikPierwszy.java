import java.io.*;
import java.util.ArrayList;

public class CzynnikPierwszy {


    public static ArrayList<Integer> sczytaj(String path){

        ArrayList<Integer> arr = new ArrayList<>();

        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line ="";
            while((line= reader.readLine()) != null){
                arr.add(Integer.parseInt(line));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = CzynnikPierwszy.sczytaj("./liczby.txt");
        ArrayList<Integer> wyniki = new ArrayList<>();

        for (int i =0 ; i<a.size(); i++){
            int c= a.get(i);
            int tmp = c%10;
            int tmp2=0;
            while(c!=0){
                tmp2=c%10;
                c=c/10;
            }
            if (tmp==tmp2){
                wyniki.add(i);
            }
        }

        for (int i =0 ; i<a.size(); i++){
            System.out.print(a.get(i)+" ");
        }
        System.out.println();
        System.out.println("Pierwsza taka liczba: " + a.get(wyniki.get(0)));
        System.out.println("Ilosc takich liczb: " + wyniki.size());
    }
}
