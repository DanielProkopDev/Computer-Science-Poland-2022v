import com.sun.source.util.Trees;

import java.util.ArrayList;
import java.util.TreeSet;

public class CzynnikRozny {


    public static void main(String[] args) {
        ArrayList<Integer> a = CzynnikPierwszy.sczytaj("./przyklad.txt");
        ArrayList<Integer> wyniki = new ArrayList<>();
        ArrayList<Integer> wyniki1 = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            TreeSet<Integer> set = new TreeSet<>();
            int c = a.get(i);
            int count=0;
            int k =2;
            while (k<=c) {
                while((c%k)==0){
                    c/=k;
                    set.add(k);
                    count++;

                }
                k++;
            }

            wyniki.add(count);
            wyniki1.add(set.size());
        }


        int index=0;
        int f = 0;
        for (int i = 0; i < wyniki.size(); i++) {
            if (f < wyniki.get(i)) {
                f=wyniki.get(i);
                index=i;
            }

        }
        System.out.println("Liczba z najwieksza iloscia czynnikow pierwszych to : "+a.get(index) + " ktorej ilosc czynnikow peirwszych wynosi: "+wyniki.get(index));
        index=0;
        f=0;
        for (int i = 0; i < wyniki1.size(); i++) {
            if (f < wyniki1.get(i)) {
                f=wyniki1.get(i);
                index=i;
            }
        }
        System.out.println("Liczba z najwieksza iloscia roznych czynnikow pierwszych to : "+a.get(index) + " ktorej ilosc roznych czynnikow peirwszych wynosi: "+wyniki.get(index));

    }
}
