import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DobraPiatka {


    public static void main(String[] args) {
        ArrayList<Integer> arr = CzynnikPierwszy.sczytaj("./przyklad.txt");
        ArrayList<Integer> wyniki = new ArrayList<>();
        int count=0;

        for (int i = 0; i < arr.size(); i++) {
            int a = arr.get(i);
            for (int j = arr.size()-1; j >=0; j--) {
                int b = arr.get(j);
                if (b%a==0&&a!=b){
                    for (int k = 0; k<arr.size() ; k++) {
                      int c = arr.get(k);
                      if (c%b==0&&c!=b){
                          for (int l = 0; l<arr.size() ; l++) {
                              int d = arr.get(l);
                              if (d%c==0&&d!=c){
                                  for (int m = 0; m<arr.size() ; m++) {
                                      int e = arr.get(m);
                                      if (e%d==0&&e!=d){
                                          wyniki.add(a);
                                          wyniki.add(b);
                                          wyniki.add(c);
                                          wyniki.add(d);
                                          wyniki.add(e);
                                          count++;
                                      }
                                  }
                              }
                          }
                      }
                    }
                }
            }
        }
        System.out.println(wyniki);
        System.out.println(count);

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("./piatki.txt"));

            for (int i = 0; i < wyniki.size(); i++) {
                if ((i+1)%5==0){
                    bw.write(wyniki.get(i-4)+" ");
                    bw.write(wyniki.get(i-3)+" ");
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
