package dambi;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

    /** Programa honek proiektuaren erroan dagoen Xanadu fitxategia karaktere karaktere irakurtzen du, 
    * karaktere bakoitza maiuskulaz characteroutput.txt fitxategian idatziz.
    */
public class CopyCharactersMaiuskulaz {
    public static void main(String[] args) throws IOException {



        try(FileReader inputStream = new FileReader("iostreams/xanadu.txt"); FileWriter outputStream = new FileWriter("iostreams/characteroutput.txt");) {


            int c;
            while ((c = inputStream.read()) != -1) {
                c=Character.toUpperCase(c);
                    outputStream.write(c); 
            }
        } 
    }
}
