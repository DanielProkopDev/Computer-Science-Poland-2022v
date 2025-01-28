import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DobraTrojka {

    public static void main(String[] args) {

        ArrayList<Integer> arr = CzynnikPierwszy.sczytaj("./przyklad.txt");
        ArrayList<Integer> wyniki = new ArrayList<>();
        int count=0;
        for(int i = 0; i<arr.size(); i++){
            int c = arr.get(i);
            for(int j = arr.size()-1; j>0; j--){
                int d = arr.get(j);
                if (d%c==0&&d!=c){
                    for (int k = 0; k < arr.size(); k++) {
                        int f= arr.get(k);
                        if(f%d==0&&f!=d){
                            wyniki.add(c);
                            wyniki.add(d);
                            wyniki.add(f);
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(wyniki);
        System.out.println(count);

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("./trojki.txt"));

            for (int i = 0; i < wyniki.size(); i++) {
                if ((i+1)%3==0){
                    bw.write(wyniki.get(i-2)+" ");
                    bw.write(wyniki.get(i-1)+" ");
                    bw.write(wyniki.get(i)+" ");
                    bw.newLine();
                }
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
