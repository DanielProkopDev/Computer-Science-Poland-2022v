import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Zapisz implements Serializable {

    String fileName;
    public void setFileName(String fileName){
        this.fileName=fileName;
        System.out.println(this.fileName);
    }



    public static void zapiszWynik(String zadanie, String wynik, String zadanie1, String wynik1, String zadanie2, String wynik2){
        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get("./Dane_2205/wyniki4.txt"),Charset.defaultCharset());
        BufferedReader reader = Files.newBufferedReader(Paths.get("./Dane_2205/wyniki4.txt"))) {
           if (reader.readLine() != null){
            writer.write(reader.readLine());}
            writer.write(zadanie);
            writer.write(" wynik:  ");
            writer.write(wynik);
            writer.newLine();
            writer.write(zadanie1);
            writer.write(" wynik:  ");
            writer.write(wynik1);
            writer.newLine();
            writer.write(zadanie2);
            writer.write(" wynik:  ");
            writer.write(wynik2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } ;
    }


}
